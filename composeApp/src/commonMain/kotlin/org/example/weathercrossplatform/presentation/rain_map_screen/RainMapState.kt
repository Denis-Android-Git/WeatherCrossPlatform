package org.example.weathercrossplatform.presentation.rain_map_screen

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

data class RainMapState(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val sliderValue: Float = 0f,
    val zoom: Int = 6,
    val date: String = currentUtcDate(),
    val hour: String = currentUtcHour(),
    val mapHtml: String = buildRainMapHtmlAndroid(
        latitude = 0.0,
        longitude = 0.0,
        zoom = 5,
        date = currentUtcDate(),
        hour = currentUtcHour()
    ),
    val currentTileUrl: String = buildTileTemplate(
        date = currentUtcDate(),
        hour = currentUtcHour()
    )
)

internal fun buildTileTemplate(date: String, hour: String): String {
    return "https://weathermaps.weatherapi.com/precip/tiles/${date}${hour}/{z}/{x}/{y}.png"
}

internal fun buildRainMapHtml(
    latitude: Double,
    longitude: Double,
    zoom: Int,
    date: String,
    hour: String,
): String {
    return buildRainMapHtmlAndroid(
        latitude = latitude,
        longitude = longitude,
        zoom = zoom,
        date = date,
        hour = hour
    )
}

internal fun buildRainMapHtmlAndroid(
    latitude: Double,
    longitude: Double,
    zoom: Int,
    date: String,
    hour: String,
): String {
    val tileUrl = buildTileTemplate(date = date, hour = hour)
    return """
        <!DOCTYPE html>
        <html lang="ru">
        <head>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
          <link
            rel="stylesheet"
            href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"
          />
          <style>
            html, body {
              margin: 0;
              height: 100%;
              width: 100%;
              overflow: hidden;
              background: #d9e6f2;
            }
            body {
              padding: 0;
              font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif;
            }
            #map {
              position: absolute;
              left: 0;
              top: 0;
              width: 100%;
              height: 100%;
              background: #d9e6f2;
            }
            #status {
              position: fixed;
              top: 10px;
              left: 10px;
              z-index: 9999;
              background: rgba(255, 255, 255, 0.94);
              color: #122033;
              padding: 8px 10px;
              border-radius: 8px;
              font-size: 14px;
              line-height: 1.35;
              box-shadow: 0 4px 16px rgba(0, 0, 0, 0.12);
            }
            .leaflet-container {
              background: #d9e6f2;
            }
            .leaflet-tile {
              max-width: none !important;
            }
          </style>
        </head>
        <body>
          <div id="status">Loading rain map...</div>
          <div id="map"></div>

          <script>
            window.L_DISABLE_3D = true;
          </script>
          <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
          <script>
            const status = document.getElementById('status');
            const mapElement = document.getElementById('map');
            let rainMapInstance = null;

            window.onerror = function(message, source, line, column) {
              status.textContent = 'Map error: ' + message + ' @' + line + ':' + column;
              console.log('window.onerror', message, source, line, column);
            };

            function setStatus(message) {
              status.textContent = message;
              console.log(message);
            }

            function sizeMapElement() {
              const width = Math.max(
                window.innerWidth || 0,
                document.documentElement.clientWidth || 0,
                1
              );
              const height = Math.max(
                window.innerHeight || 0,
                document.documentElement.clientHeight || 0,
                1
              );
              mapElement.style.width = width + 'px';
              mapElement.style.height = height + 'px';
              return { width, height };
            }

            window.forceLeafletLayout = function() {
              const size = sizeMapElement();
              if (rainMapInstance) {
                rainMapInstance.invalidateSize(true);
                setStatus('Forced map layout [' + size.width + 'x' + size.height + ']');
              } else {
                setStatus('Map instance not ready [' + size.width + 'x' + size.height + ']');
              }
            };

            function initMap() {
              if (!window.L) {
                setStatus('Leaflet failed to load');
                return;
              }

              const initialSize = sizeMapElement();

              const map = L.map('map', {
                center: [$latitude, $longitude],
                zoom: $zoom,
                zoomControl: false,
                attributionControl: false,
                preferCanvas: false,
                zoomAnimation: false,
                fadeAnimation: false,
                markerZoomAnimation: false,
              });
              rainMapInstance = map;

              const baseLayer = L.tileLayer(
                'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                {
                  maxZoom: 19,
                }
              );

              const rainLayer = L.tileLayer(
                '$tileUrl',
                {
                  maxZoom: 19,
                  opacity: 0.45,
                }
              );

              let baseLoaded = false;
              let rainLoaded = false;

              function updateReadyState() {
                if (baseLoaded && rainLoaded) {
                  setStatus('Map ready UTC $date $hour [' + map.getSize().x + 'x' + map.getSize().y + ']');
                }
              }

              baseLayer.on('loading', function() {
                setStatus('Loading base layer...');
              });
              baseLayer.on('load', function() {
                baseLoaded = true;
                updateReadyState();
              });
              baseLayer.on('tileerror', function(event) {
                console.log('Base tile error', event);
                setStatus('Base tile error');
              });

              rainLayer.on('loading', function() {
                setStatus('Loading rain layer...');
              });
              rainLayer.on('load', function() {
                rainLoaded = true;
                updateReadyState();
              });
              rainLayer.on('tileerror', function(event) {
                console.log('Rain tile error', event);
                setStatus('Rain tile error');
              });

              baseLayer.addTo(map);
              rainLayer.addTo(map);

              setTimeout(function() {
                window.forceLeafletLayout();
              }, 0);
              setTimeout(function() {
                window.forceLeafletLayout();
              }, 250);
              setTimeout(function() {
                window.forceLeafletLayout();
              }, 1000);

              window.addEventListener('resize', function() {
                const size = sizeMapElement();
                map.invalidateSize(true);
                setStatus('Resized map [' + size.width + 'x' + size.height + ']');
              });

              setStatus('Initializing map [' + initialSize.width + 'x' + initialSize.height + ']');
            }

            if (document.readyState === 'loading') {
              document.addEventListener('DOMContentLoaded', initMap);
            } else {
              initMap();
            }
          </script>
        </body>
        </html>
    """.trimIndent()
}

internal fun buildRainMapHtmlIos(
    latitude: Double,
    longitude: Double,
    zoom: Int,
    date: String,
    hour: String,
): String {
    val tileUrl = buildTileTemplate(date = date, hour = hour)
    return """
        <!DOCTYPE html>
        <html lang="ru">
        <head>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <style>
            html, body {
              margin: 0;
              width: 100%;
              height: 100%;
              background: #d9e6f2;
              overflow: hidden;
            }
            #map {
              position: fixed;
              inset: 0;
              width: 100vw;
              height: 100vh;
              background: #d9e6f2;
              overflow: hidden;
            }
            #base-layer,
            #rain-layer {
              position: absolute;
              inset: 0;
            }
            .tile {
              position: absolute;
              width: 256px;
              height: 256px;
              user-select: none;
              -webkit-user-drag: none;
            }
            #status {
              position: fixed;
              top: 10px;
              left: 10px;
              z-index: 9999;
              background: rgba(255, 255, 255, 0.95);
              color: #122033;
              padding: 8px 10px;
              border-radius: 8px;
              font: 14px sans-serif;
              box-shadow: 0 4px 16px rgba(0, 0, 0, 0.12);
            }
            #rain-layer .tile {
              opacity: 0.45;
            }
          </style>
        </head>
        <body>
          <div id="status">Loading rain map...</div>
          <div id="map">
            <div id="base-layer"></div>
            <div id="rain-layer"></div>
          </div>

          <script>
            const status = document.getElementById('status');
            const map = document.getElementById('map');
            const baseLayer = document.getElementById('base-layer');
            const rainLayer = document.getElementById('rain-layer');
            const tileSize = 256;
            const zoom = $zoom;
            const latitude = $latitude;
            const longitude = $longitude;
            const osmTemplate = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png';
            const rainTemplate = '$tileUrl';

            window.onerror = function(message, source, line) {
              status.textContent = 'Map error: ' + message;
              console.log('window.onerror', message, source, line);
            };

            function clamp(value, min, max) {
              return Math.min(Math.max(value, min), max);
            }

            function wrapX(x, tilesPerAxis) {
              return ((x % tilesPerAxis) + tilesPerAxis) % tilesPerAxis;
            }

            function latLonToWorldPixels(lat, lon, z) {
              const scale = tileSize * Math.pow(2, z);
              const sinLat = Math.sin(lat * Math.PI / 180);
              const clampedSin = clamp(sinLat, -0.9999, 0.9999);
              const x = ((lon + 180) / 360) * scale;
              const y = (0.5 - Math.log((1 + clampedSin) / (1 - clampedSin)) / (4 * Math.PI)) * scale;
              return { x, y };
            }

            function osmUrl(z, x, y) {
              return osmTemplate
                .replace('{z}', String(z))
                .replace('{x}', String(x))
                .replace('{y}', String(y));
            }

            function weatherUrl(z, x, y) {
              return rainTemplate
                .replace('{z}', String(z))
                .replace('{x}', String(x))
                .replace('{y}', String(y));
            }

            function makeTile(src, left, top, onLoad, onError) {
              const img = document.createElement('img');
              img.className = 'tile';
              img.alt = '';
              img.src = src;
              img.style.left = left + 'px';
              img.style.top = top + 'px';
              img.onload = onLoad;
              img.onerror = onError;
              return img;
            }

            function render() {
              baseLayer.innerHTML = '';
              rainLayer.innerHTML = '';

              const mapWidth = map.clientWidth || window.innerWidth || document.documentElement.clientWidth || 1;
              const mapHeight = map.clientHeight || window.innerHeight || document.documentElement.clientHeight || 1;
              const world = latLonToWorldPixels(latitude, longitude, zoom);
              const topLeftX = world.x - mapWidth / 2;
              const topLeftY = world.y - mapHeight / 2;
              const tilesPerAxis = Math.pow(2, zoom);
              const minTileX = Math.floor(topLeftX / tileSize);
              const maxTileX = Math.floor((topLeftX + mapWidth) / tileSize);
              const minTileY = Math.floor(topLeftY / tileSize);
              const maxTileY = Math.floor((topLeftY + mapHeight) / tileSize);
              const maxY = tilesPerAxis - 1;

              let pendingTiles = 0;
              let failedTiles = 0;

              function markLoaded() {
                pendingTiles -= 1;
                if (pendingTiles <= 0) {
                  status.textContent = failedTiles > 0
                    ? 'Map loaded with ' + failedTiles + ' tile errors'
                    : 'Map ready UTC $date $hour';
                }
              }

              function markFailed(label, url) {
                failedTiles += 1;
                console.log(label + ' tile error', url);
                markLoaded();
              }

              for (let tileX = minTileX; tileX <= maxTileX; tileX += 1) {
                for (let tileY = minTileY; tileY <= maxTileY; tileY += 1) {
                  if (tileY < 0 || tileY > maxY) {
                    continue;
                  }

                  const wrappedX = wrapX(tileX, tilesPerAxis);
                  const left = tileX * tileSize - topLeftX;
                  const top = tileY * tileSize - topLeftY;

                  pendingTiles += 2;

                  baseLayer.appendChild(
                    makeTile(
                      osmUrl(zoom, wrappedX, tileY),
                      left,
                      top,
                      markLoaded,
                      function() { markFailed('Base', this.src); }
                    )
                  );

                  rainLayer.appendChild(
                    makeTile(
                      weatherUrl(zoom, wrappedX, tileY),
                      left,
                      top,
                      markLoaded,
                      function() { markFailed('Rain', this.src); }
                    )
                  );
                }
              }

              if (pendingTiles === 0) {
                status.textContent = 'No tiles for selected viewport';
              } else {
                status.textContent = 'Loading ' + pendingTiles + ' tiles...';
              }
            }

            render();
            window.addEventListener('resize', render);
          </script>
        </body>
        </html>
    """.trimIndent()
}

internal fun currentUtcDate(): String {
    val now = weatherMapTimestamp()
        .toLocalDateTime(TimeZone.UTC)
    return buildString {
        append(now.year.toString().padStart(4, '0'))
        append(now.month.number.toString().padStart(2, '0'))
        append(now.day.toString().padStart(2, '0'))
    }
}

internal fun currentUtcHour(): String {
    val now = weatherMapTimestamp()
        .toLocalDateTime(TimeZone.UTC)
    return now.hour.toString().padStart(2, '0')
}

internal data class UtcRainMapDateTime(
    val date: String,
    val hour: String,
)

internal fun currentTimeToUtcDateTime(currentHour: Int): UtcRainMapDateTime {
    val normalizedHour = currentHour.coerceIn(0, 23)
    val localZone = TimeZone.currentSystemDefault()
    val localNow = weatherMapTimestamp().toLocalDateTime(localZone)
    val localDateTime = LocalDateTime(
        year = localNow.year,
        month = localNow.month.number,
        day = localNow.day,
        hour = normalizedHour,
        minute = 0,
        second = 0,
        nanosecond = 0
    )
    val utcDateTime = localDateTime
        .toInstant(localZone)
        .toLocalDateTime(TimeZone.UTC)

    return UtcRainMapDateTime(
        date = formatDate(utcDateTime.year, utcDateTime.month.number, utcDateTime.day),
        hour = utcDateTime.hour.toString().padStart(2, '0')
    )
}

private fun formatDate(year: Int, month: Int, day: Int): String {
    return buildString {
        append(year.toString().padStart(4, '0'))
        append(month.toString().padStart(2, '0'))
        append(day.toString().padStart(2, '0'))
    }
}

private fun weatherMapTimestamp() = Clock.System.now()

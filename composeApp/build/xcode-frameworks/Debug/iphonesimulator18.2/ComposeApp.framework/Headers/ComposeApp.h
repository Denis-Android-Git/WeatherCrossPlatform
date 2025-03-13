#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class ComposeAppAirQuality, ComposeAppAirQualityCompanion, ComposeAppCondition, ComposeAppConditionCompanion, ComposeAppCoordinates, ComposeAppCurrent, ComposeAppCurrentCompanion, ComposeAppCurrentWeatherDto, ComposeAppCurrentWeatherDtoCompanion, ComposeAppKoin_coreBeanDefinition<T>, ComposeAppKoin_coreCallbacks<T>, ComposeAppKoin_coreExtensionManager, ComposeAppKoin_coreInstanceFactory<T>, ComposeAppKoin_coreInstanceFactoryCompanion, ComposeAppKoin_coreInstanceRegistry, ComposeAppKoin_coreKind, ComposeAppKoin_coreKoin, ComposeAppKoin_coreKoinApplication, ComposeAppKoin_coreKoinApplicationCompanion, ComposeAppKoin_coreKoinDefinition<R>, ComposeAppKoin_coreLevel, ComposeAppKoin_coreLockable, ComposeAppKoin_coreLogger, ComposeAppKoin_coreModule, ComposeAppKoin_coreParametersHolder, ComposeAppKoin_corePropertyRegistry, ComposeAppKoin_coreResolutionContext, ComposeAppKoin_coreScope, ComposeAppKoin_coreScopeDSL, ComposeAppKoin_coreScopeRegistry, ComposeAppKoin_coreScopeRegistryCompanion, ComposeAppKoin_coreSingleInstanceFactory<T>, ComposeAppKotlinAbstractCoroutineContextElement, ComposeAppKotlinAbstractCoroutineContextKey<B, E>, ComposeAppKotlinArray<T>, ComposeAppKotlinByteArray, ComposeAppKotlinByteIterator, ComposeAppKotlinCancellationException, ComposeAppKotlinEnum<E>, ComposeAppKotlinEnumCompanion, ComposeAppKotlinException, ComposeAppKotlinIllegalStateException, ComposeAppKotlinKTypeProjection, ComposeAppKotlinKTypeProjectionCompanion, ComposeAppKotlinKVariance, ComposeAppKotlinLazyThreadSafetyMode, ComposeAppKotlinNothing, ComposeAppKotlinRuntimeException, ComposeAppKotlinThrowable, ComposeAppKotlinUnit, ComposeAppKotlinx_coroutines_coreCoroutineDispatcher, ComposeAppKotlinx_coroutines_coreCoroutineDispatcherKey, ComposeAppKotlinx_serialization_coreSerialKind, ComposeAppKotlinx_serialization_coreSerializersModule, ComposeAppKtor_client_coreHttpClient, ComposeAppKtor_client_coreHttpClientCall, ComposeAppKtor_client_coreHttpClientCallCompanion, ComposeAppKtor_client_coreHttpClientConfig<T>, ComposeAppKtor_client_coreHttpClientEngineConfig, ComposeAppKtor_client_coreHttpReceivePipeline, ComposeAppKtor_client_coreHttpReceivePipelinePhases, ComposeAppKtor_client_coreHttpRequestBuilder, ComposeAppKtor_client_coreHttpRequestBuilderCompanion, ComposeAppKtor_client_coreHttpRequestData, ComposeAppKtor_client_coreHttpRequestPipeline, ComposeAppKtor_client_coreHttpRequestPipelinePhases, ComposeAppKtor_client_coreHttpResponse, ComposeAppKtor_client_coreHttpResponseContainer, ComposeAppKtor_client_coreHttpResponseData, ComposeAppKtor_client_coreHttpResponsePipeline, ComposeAppKtor_client_coreHttpResponsePipelinePhases, ComposeAppKtor_client_coreHttpSendPipeline, ComposeAppKtor_client_coreHttpSendPipelinePhases, ComposeAppKtor_client_coreProxyConfig, ComposeAppKtor_eventsEventDefinition<T>, ComposeAppKtor_eventsEvents, ComposeAppKtor_httpContentType, ComposeAppKtor_httpContentTypeCompanion, ComposeAppKtor_httpHeaderValueParam, ComposeAppKtor_httpHeaderValueWithParameters, ComposeAppKtor_httpHeaderValueWithParametersCompanion, ComposeAppKtor_httpHeadersBuilder, ComposeAppKtor_httpHttpMethod, ComposeAppKtor_httpHttpMethodCompanion, ComposeAppKtor_httpHttpProtocolVersion, ComposeAppKtor_httpHttpProtocolVersionCompanion, ComposeAppKtor_httpHttpStatusCode, ComposeAppKtor_httpHttpStatusCodeCompanion, ComposeAppKtor_httpOutgoingContent, ComposeAppKtor_httpURLBuilder, ComposeAppKtor_httpURLBuilderCompanion, ComposeAppKtor_httpURLProtocol, ComposeAppKtor_httpURLProtocolCompanion, ComposeAppKtor_httpUrl, ComposeAppKtor_httpUrlCompanion, ComposeAppKtor_ioBuffer, ComposeAppKtor_ioBufferCompanion, ComposeAppKtor_ioByteReadPacket, ComposeAppKtor_ioByteReadPacketCompanion, ComposeAppKtor_ioChunkBuffer, ComposeAppKtor_ioChunkBufferCompanion, ComposeAppKtor_ioInput, ComposeAppKtor_ioInputCompanion, ComposeAppKtor_ioMemory, ComposeAppKtor_ioMemoryCompanion, ComposeAppKtor_utilsAttributeKey<T>, ComposeAppKtor_utilsGMTDate, ComposeAppKtor_utilsGMTDateCompanion, ComposeAppKtor_utilsMonth, ComposeAppKtor_utilsMonthCompanion, ComposeAppKtor_utilsPipeline<TSubject, TContext>, ComposeAppKtor_utilsPipelinePhase, ComposeAppKtor_utilsStringValuesBuilderImpl, ComposeAppKtor_utilsTypeInfo, ComposeAppKtor_utilsWeekDay, ComposeAppKtor_utilsWeekDayCompanion, ComposeAppLifecycle_viewmodelViewModel, ComposeAppLocation, ComposeAppLocationCompanion, ComposeAppLocationService, ComposeAppNetworkError, ComposeAppPermissionsPermission, ComposeAppPermissionsPermissionState, ComposeAppResultError<__covariant E>, ComposeAppResultSuccess<__covariant D>, ComposeAppWeatherRepoImpl, UIViewController;

@protocol ComposeAppError, ComposeAppKoin_coreKoinComponent, ComposeAppKoin_coreKoinExtension, ComposeAppKoin_coreKoinScopeComponent, ComposeAppKoin_coreQualifier, ComposeAppKoin_coreScopeCallback, ComposeAppKotlinAnnotation, ComposeAppKotlinAppendable, ComposeAppKotlinAutoCloseable, ComposeAppKotlinComparable, ComposeAppKotlinContinuation, ComposeAppKotlinContinuationInterceptor, ComposeAppKotlinCoroutineContext, ComposeAppKotlinCoroutineContextElement, ComposeAppKotlinCoroutineContextKey, ComposeAppKotlinFunction, ComposeAppKotlinIterator, ComposeAppKotlinKAnnotatedElement, ComposeAppKotlinKClass, ComposeAppKotlinKClassifier, ComposeAppKotlinKDeclarationContainer, ComposeAppKotlinKType, ComposeAppKotlinLazy, ComposeAppKotlinMapEntry, ComposeAppKotlinSequence, ComposeAppKotlinSuspendFunction1, ComposeAppKotlinSuspendFunction2, ComposeAppKotlinx_coroutines_coreChildHandle, ComposeAppKotlinx_coroutines_coreChildJob, ComposeAppKotlinx_coroutines_coreCoroutineScope, ComposeAppKotlinx_coroutines_coreDisposableHandle, ComposeAppKotlinx_coroutines_coreFlow, ComposeAppKotlinx_coroutines_coreFlowCollector, ComposeAppKotlinx_coroutines_coreJob, ComposeAppKotlinx_coroutines_coreParentJob, ComposeAppKotlinx_coroutines_coreRunnable, ComposeAppKotlinx_coroutines_coreSelectClause, ComposeAppKotlinx_coroutines_coreSelectClause0, ComposeAppKotlinx_coroutines_coreSelectInstance, ComposeAppKotlinx_coroutines_coreSharedFlow, ComposeAppKotlinx_coroutines_coreStateFlow, ComposeAppKotlinx_serialization_coreCompositeDecoder, ComposeAppKotlinx_serialization_coreCompositeEncoder, ComposeAppKotlinx_serialization_coreDecoder, ComposeAppKotlinx_serialization_coreDeserializationStrategy, ComposeAppKotlinx_serialization_coreEncoder, ComposeAppKotlinx_serialization_coreKSerializer, ComposeAppKotlinx_serialization_coreSerialDescriptor, ComposeAppKotlinx_serialization_coreSerializationStrategy, ComposeAppKotlinx_serialization_coreSerializersModuleCollector, ComposeAppKtor_client_coreHttpClientEngine, ComposeAppKtor_client_coreHttpClientEngineCapability, ComposeAppKtor_client_coreHttpClientPlugin, ComposeAppKtor_client_coreHttpRequest, ComposeAppKtor_httpHeaders, ComposeAppKtor_httpHttpMessage, ComposeAppKtor_httpHttpMessageBuilder, ComposeAppKtor_httpParameters, ComposeAppKtor_httpParametersBuilder, ComposeAppKtor_ioByteReadChannel, ComposeAppKtor_ioCloseable, ComposeAppKtor_ioObjectPool, ComposeAppKtor_ioReadSession, ComposeAppKtor_utilsAttributes, ComposeAppKtor_utilsStringValues, ComposeAppKtor_utilsStringValuesBuilder, ComposeAppPermissionsPermissionsControllerProtocol, ComposeAppResult, ComposeAppWeatherRepo;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface ComposeAppBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface ComposeAppBase (ComposeAppBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface ComposeAppMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface ComposeAppMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorComposeAppKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface ComposeAppNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface ComposeAppByte : ComposeAppNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface ComposeAppUByte : ComposeAppNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface ComposeAppShort : ComposeAppNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface ComposeAppUShort : ComposeAppNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface ComposeAppInt : ComposeAppNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface ComposeAppUInt : ComposeAppNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface ComposeAppLong : ComposeAppNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface ComposeAppULong : ComposeAppNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface ComposeAppFloat : ComposeAppNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface ComposeAppDouble : ComposeAppNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface ComposeAppBoolean : ComposeAppNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LocationService")))
@interface ComposeAppLocationService : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getLocationWithCompletionHandler:(void (^)(id<ComposeAppKotlinx_coroutines_coreFlow> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getLocation(completionHandler:)")));
@end

__attribute__((swift_name("WeatherRepo")))
@protocol ComposeAppWeatherRepo
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCurrentWeatherQuery:(NSString *)query completionHandler:(void (^)(id<ComposeAppResult> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getCurrentWeather(query:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("WeatherRepoImpl")))
@interface ComposeAppWeatherRepoImpl : ComposeAppBase <ComposeAppWeatherRepo>
- (instancetype)initWithHttpClient:(ComposeAppKtor_client_coreHttpClient *)httpClient __attribute__((swift_name("init(httpClient:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCurrentWeatherQuery:(NSString *)query completionHandler:(void (^)(id<ComposeAppResult> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getCurrentWeather(query:completionHandler:)")));
@end

__attribute__((swift_name("Error")))
@protocol ComposeAppError
@required
@end

__attribute__((swift_name("KotlinComparable")))
@protocol ComposeAppKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface ComposeAppKotlinEnum<E> : ComposeAppBase <ComposeAppKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("NetworkError")))
@interface ComposeAppNetworkError : ComposeAppKotlinEnum<ComposeAppNetworkError *> <ComposeAppError>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppNetworkError *requestTimeout __attribute__((swift_name("requestTimeout")));
@property (class, readonly) ComposeAppNetworkError *unauthorized __attribute__((swift_name("unauthorized")));
@property (class, readonly) ComposeAppNetworkError *conflict __attribute__((swift_name("conflict")));
@property (class, readonly) ComposeAppNetworkError *tooManyRequests __attribute__((swift_name("tooManyRequests")));
@property (class, readonly) ComposeAppNetworkError *noInternet __attribute__((swift_name("noInternet")));
@property (class, readonly) ComposeAppNetworkError *payloadTooLarge __attribute__((swift_name("payloadTooLarge")));
@property (class, readonly) ComposeAppNetworkError *serverError __attribute__((swift_name("serverError")));
@property (class, readonly) ComposeAppNetworkError *serialization __attribute__((swift_name("serialization")));
@property (class, readonly) ComposeAppNetworkError *unknown __attribute__((swift_name("unknown")));
+ (ComposeAppKotlinArray<ComposeAppNetworkError *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppNetworkError *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((swift_name("Result")))
@protocol ComposeAppResult
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ResultError")))
@interface ComposeAppResultError<__covariant E> : ComposeAppBase <ComposeAppResult>
- (instancetype)initWithError:(E)error __attribute__((swift_name("init(error:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppResultError<E> *)doCopyError:(E)error __attribute__((swift_name("doCopy(error:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) E error __attribute__((swift_name("error")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ResultSuccess")))
@interface ComposeAppResultSuccess<__covariant D> : ComposeAppBase <ComposeAppResult>
- (instancetype)initWithData:(D _Nullable)data __attribute__((swift_name("init(data:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppResultSuccess<D> *)doCopyData:(D _Nullable)data __attribute__((swift_name("doCopy(data:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) D _Nullable data __attribute__((swift_name("data")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AirQuality")))
@interface ComposeAppAirQuality : ComposeAppBase
- (instancetype)initWithCo:(double)co gbDefraIndex:(int32_t)gbDefraIndex no2:(double)no2 o3:(double)o3 pm10:(double)pm10 pm25:(double)pm25 so2:(double)so2 usEpaIndex:(int32_t)usEpaIndex __attribute__((swift_name("init(co:gbDefraIndex:no2:o3:pm10:pm25:so2:usEpaIndex:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppAirQualityCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppAirQuality *)doCopyCo:(double)co gbDefraIndex:(int32_t)gbDefraIndex no2:(double)no2 o3:(double)o3 pm10:(double)pm10 pm25:(double)pm25 so2:(double)so2 usEpaIndex:(int32_t)usEpaIndex __attribute__((swift_name("doCopy(co:gbDefraIndex:no2:o3:pm10:pm25:so2:usEpaIndex:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) double co __attribute__((swift_name("co")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gb-defra-index")
*/
@property (readonly) int32_t gbDefraIndex __attribute__((swift_name("gbDefraIndex")));
@property (readonly) double no2 __attribute__((swift_name("no2")));
@property (readonly) double o3 __attribute__((swift_name("o3")));
@property (readonly) double pm10 __attribute__((swift_name("pm10")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="pm2_5")
*/
@property (readonly) double pm25 __attribute__((swift_name("pm25")));
@property (readonly) double so2 __attribute__((swift_name("so2")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="us-epa-index")
*/
@property (readonly) int32_t usEpaIndex __attribute__((swift_name("usEpaIndex")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AirQuality.Companion")))
@interface ComposeAppAirQualityCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppAirQualityCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Condition")))
@interface ComposeAppCondition : ComposeAppBase
- (instancetype)initWithCode:(int32_t)code icon:(NSString *)icon text:(NSString *)text __attribute__((swift_name("init(code:icon:text:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppConditionCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppCondition *)doCopyCode:(int32_t)code icon:(NSString *)icon text:(NSString *)text __attribute__((swift_name("doCopy(code:icon:text:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t code __attribute__((swift_name("code")));
@property (readonly) NSString *icon __attribute__((swift_name("icon")));
@property (readonly) NSString *text __attribute__((swift_name("text")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Condition.Companion")))
@interface ComposeAppConditionCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppConditionCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Coordinates")))
@interface ComposeAppCoordinates : ComposeAppBase
- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude __attribute__((swift_name("init(latitude:longitude:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppCoordinates *)doCopyLatitude:(double)latitude longitude:(double)longitude __attribute__((swift_name("doCopy(latitude:longitude:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) double latitude __attribute__((swift_name("latitude")));
@property (readonly) double longitude __attribute__((swift_name("longitude")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Current")))
@interface ComposeAppCurrent : ComposeAppBase
- (instancetype)initWithAirQuality:(ComposeAppAirQuality *)airQuality cloud:(int32_t)cloud condition:(ComposeAppCondition *)condition dewPointC:(double)dewPointC dewPointF:(double)dewPointF feelsLikeC:(double)feelsLikeC feelsLikeF:(double)feelsLikeF gustKph:(double)gustKph gustMph:(double)gustMph heatIndexC:(double)heatIndexC heatIndexF:(double)heatIndexF humidity:(int32_t)humidity isDay:(int32_t)isDay lastUpdated:(NSString *)lastUpdated lastUpdatedEpoch:(int32_t)lastUpdatedEpoch precipIn:(double)precipIn precipMm:(double)precipMm pressureIn:(double)pressureIn pressureMb:(double)pressureMb tempC:(double)tempC tempF:(double)tempF uv:(double)uv visKm:(double)visKm visMiles:(double)visMiles windDegree:(int32_t)windDegree windDir:(NSString *)windDir windKph:(double)windKph windMph:(double)windMph windChillC:(double)windChillC windChillF:(double)windChillF __attribute__((swift_name("init(airQuality:cloud:condition:dewPointC:dewPointF:feelsLikeC:feelsLikeF:gustKph:gustMph:heatIndexC:heatIndexF:humidity:isDay:lastUpdated:lastUpdatedEpoch:precipIn:precipMm:pressureIn:pressureMb:tempC:tempF:uv:visKm:visMiles:windDegree:windDir:windKph:windMph:windChillC:windChillF:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppCurrentCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppCurrent *)doCopyAirQuality:(ComposeAppAirQuality *)airQuality cloud:(int32_t)cloud condition:(ComposeAppCondition *)condition dewPointC:(double)dewPointC dewPointF:(double)dewPointF feelsLikeC:(double)feelsLikeC feelsLikeF:(double)feelsLikeF gustKph:(double)gustKph gustMph:(double)gustMph heatIndexC:(double)heatIndexC heatIndexF:(double)heatIndexF humidity:(int32_t)humidity isDay:(int32_t)isDay lastUpdated:(NSString *)lastUpdated lastUpdatedEpoch:(int32_t)lastUpdatedEpoch precipIn:(double)precipIn precipMm:(double)precipMm pressureIn:(double)pressureIn pressureMb:(double)pressureMb tempC:(double)tempC tempF:(double)tempF uv:(double)uv visKm:(double)visKm visMiles:(double)visMiles windDegree:(int32_t)windDegree windDir:(NSString *)windDir windKph:(double)windKph windMph:(double)windMph windChillC:(double)windChillC windChillF:(double)windChillF __attribute__((swift_name("doCopy(airQuality:cloud:condition:dewPointC:dewPointF:feelsLikeC:feelsLikeF:gustKph:gustMph:heatIndexC:heatIndexF:humidity:isDay:lastUpdated:lastUpdatedEpoch:precipIn:precipMm:pressureIn:pressureMb:tempC:tempF:uv:visKm:visMiles:windDegree:windDir:windKph:windMph:windChillC:windChillF:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="air_quality")
*/
@property (readonly) ComposeAppAirQuality *airQuality __attribute__((swift_name("airQuality")));
@property (readonly) int32_t cloud __attribute__((swift_name("cloud")));
@property (readonly) ComposeAppCondition *condition __attribute__((swift_name("condition")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="dewpoint_c")
*/
@property (readonly) double dewPointC __attribute__((swift_name("dewPointC")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="dewpoint_f")
*/
@property (readonly) double dewPointF __attribute__((swift_name("dewPointF")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="feelslike_c")
*/
@property (readonly) double feelsLikeC __attribute__((swift_name("feelsLikeC")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="feelslike_f")
*/
@property (readonly) double feelsLikeF __attribute__((swift_name("feelsLikeF")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gust_kph")
*/
@property (readonly) double gustKph __attribute__((swift_name("gustKph")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="gust_mph")
*/
@property (readonly) double gustMph __attribute__((swift_name("gustMph")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="heatindex_c")
*/
@property (readonly) double heatIndexC __attribute__((swift_name("heatIndexC")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="heatindex_f")
*/
@property (readonly) double heatIndexF __attribute__((swift_name("heatIndexF")));
@property (readonly) int32_t humidity __attribute__((swift_name("humidity")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="is_day")
*/
@property (readonly) int32_t isDay __attribute__((swift_name("isDay")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="last_updated")
*/
@property (readonly) NSString *lastUpdated __attribute__((swift_name("lastUpdated")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="last_updated_epoch")
*/
@property (readonly) int32_t lastUpdatedEpoch __attribute__((swift_name("lastUpdatedEpoch")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="precip_in")
*/
@property (readonly) double precipIn __attribute__((swift_name("precipIn")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="precip_mm")
*/
@property (readonly) double precipMm __attribute__((swift_name("precipMm")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="pressure_in")
*/
@property (readonly) double pressureIn __attribute__((swift_name("pressureIn")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="pressure_mb")
*/
@property (readonly) double pressureMb __attribute__((swift_name("pressureMb")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="temp_c")
*/
@property (readonly) double tempC __attribute__((swift_name("tempC")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="temp_f")
*/
@property (readonly) double tempF __attribute__((swift_name("tempF")));
@property (readonly) double uv __attribute__((swift_name("uv")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="vis_km")
*/
@property (readonly) double visKm __attribute__((swift_name("visKm")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="vis_miles")
*/
@property (readonly) double visMiles __attribute__((swift_name("visMiles")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="windchill_c")
*/
@property (readonly) double windChillC __attribute__((swift_name("windChillC")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="windchill_f")
*/
@property (readonly) double windChillF __attribute__((swift_name("windChillF")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="wind_degree")
*/
@property (readonly) int32_t windDegree __attribute__((swift_name("windDegree")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="wind_dir")
*/
@property (readonly) NSString *windDir __attribute__((swift_name("windDir")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="wind_kph")
*/
@property (readonly) double windKph __attribute__((swift_name("windKph")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="wind_mph")
*/
@property (readonly) double windMph __attribute__((swift_name("windMph")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Current.Companion")))
@interface ComposeAppCurrentCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppCurrentCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Location")))
@interface ComposeAppLocation : ComposeAppBase
- (instancetype)initWithCountry:(NSString *)country lat:(double)lat localtime:(NSString *)localtime localTimeEpoch:(int32_t)localTimeEpoch lon:(double)lon name:(NSString *)name region:(NSString *)region tzId:(NSString *)tzId __attribute__((swift_name("init(country:lat:localtime:localTimeEpoch:lon:name:region:tzId:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppLocationCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppLocation *)doCopyCountry:(NSString *)country lat:(double)lat localtime:(NSString *)localtime localTimeEpoch:(int32_t)localTimeEpoch lon:(double)lon name:(NSString *)name region:(NSString *)region tzId:(NSString *)tzId __attribute__((swift_name("doCopy(country:lat:localtime:localTimeEpoch:lon:name:region:tzId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *country __attribute__((swift_name("country")));
@property (readonly) double lat __attribute__((swift_name("lat")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="localtime_epoch")
*/
@property (readonly) int32_t localTimeEpoch __attribute__((swift_name("localTimeEpoch")));
@property (readonly) NSString *localtime __attribute__((swift_name("localtime")));
@property (readonly) double lon __attribute__((swift_name("lon")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *region __attribute__((swift_name("region")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="tz_id")
*/
@property (readonly) NSString *tzId __attribute__((swift_name("tzId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Location.Companion")))
@interface ComposeAppLocationCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppLocationCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CurrentWeatherDto")))
@interface ComposeAppCurrentWeatherDto : ComposeAppBase
- (instancetype)initWithCurrent:(ComposeAppCurrent *)current location:(ComposeAppLocation *)location __attribute__((swift_name("init(current:location:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppCurrentWeatherDtoCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppCurrentWeatherDto *)doCopyCurrent:(ComposeAppCurrent *)current location:(ComposeAppLocation *)location __attribute__((swift_name("doCopy(current:location:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppCurrent *current __attribute__((swift_name("current")));
@property (readonly) ComposeAppLocation *location __attribute__((swift_name("location")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CurrentWeatherDto.Companion")))
@interface ComposeAppCurrentWeatherDtoCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppCurrentWeatherDtoCompanion *shared __attribute__((swift_name("shared")));
- (id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("Lifecycle_viewmodelViewModel")))
@interface ComposeAppLifecycle_viewmodelViewModel : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithCloseables:(ComposeAppKotlinArray<id<ComposeAppKotlinAutoCloseable>> *)closeables __attribute__((swift_name("init(closeables:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithViewModelScope:(id<ComposeAppKotlinx_coroutines_coreCoroutineScope>)viewModelScope __attribute__((swift_name("init(viewModelScope:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithViewModelScope:(id<ComposeAppKotlinx_coroutines_coreCoroutineScope>)viewModelScope closeables:(ComposeAppKotlinArray<id<ComposeAppKotlinAutoCloseable>> *)closeables __attribute__((swift_name("init(viewModelScope:closeables:)"))) __attribute__((objc_designated_initializer));
- (void)addCloseableCloseable:(id<ComposeAppKotlinAutoCloseable>)closeable __attribute__((swift_name("addCloseable(closeable:)")));
- (void)addCloseableKey:(NSString *)key closeable:(id<ComposeAppKotlinAutoCloseable>)closeable __attribute__((swift_name("addCloseable(key:closeable:)")));
- (id<ComposeAppKotlinAutoCloseable> _Nullable)getCloseableKey:(NSString *)key __attribute__((swift_name("getCloseable(key:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)onCleared __attribute__((swift_name("onCleared()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PermissionsViewModel")))
@interface ComposeAppPermissionsViewModel : ComposeAppLifecycle_viewmodelViewModel
- (instancetype)initWithPermissionsController:(id<ComposeAppPermissionsPermissionsControllerProtocol>)permissionsController __attribute__((swift_name("init(permissionsController:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithCloseables:(ComposeAppKotlinArray<id<ComposeAppKotlinAutoCloseable>> *)closeables __attribute__((swift_name("init(closeables:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithViewModelScope:(id<ComposeAppKotlinx_coroutines_coreCoroutineScope>)viewModelScope __attribute__((swift_name("init(viewModelScope:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithViewModelScope:(id<ComposeAppKotlinx_coroutines_coreCoroutineScope>)viewModelScope closeables:(ComposeAppKotlinArray<id<ComposeAppKotlinAutoCloseable>> *)closeables __attribute__((swift_name("init(viewModelScope:closeables:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (void)checkPermissions __attribute__((swift_name("checkPermissions()")));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreStateFlow> state __attribute__((swift_name("state")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("WeatherViewModel")))
@interface ComposeAppWeatherViewModel : ComposeAppLifecycle_viewmodelViewModel
- (instancetype)initWithLocationService:(ComposeAppLocationService *)locationService weatherRepoImpl:(ComposeAppWeatherRepoImpl *)weatherRepoImpl __attribute__((swift_name("init(locationService:weatherRepoImpl:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithCloseables:(ComposeAppKotlinArray<id<ComposeAppKotlinAutoCloseable>> *)closeables __attribute__((swift_name("init(closeables:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithViewModelScope:(id<ComposeAppKotlinx_coroutines_coreCoroutineScope>)viewModelScope __attribute__((swift_name("init(viewModelScope:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithViewModelScope:(id<ComposeAppKotlinx_coroutines_coreCoroutineScope>)viewModelScope closeables:(ComposeAppKotlinArray<id<ComposeAppKotlinAutoCloseable>> *)closeables __attribute__((swift_name("init(viewModelScope:closeables:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreStateFlow> error __attribute__((swift_name("error")));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreStateFlow> weather __attribute__((swift_name("weather")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("InitKoinKt")))
@interface ComposeAppInitKoinKt : ComposeAppBase
+ (void)doInitKoinConfig:(void (^ _Nullable)(ComposeAppKoin_coreKoinApplication *))config __attribute__((swift_name("doInitKoin(config:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MainViewControllerKt")))
@interface ComposeAppMainViewControllerKt : ComposeAppBase
+ (UIViewController *)MainViewController __attribute__((swift_name("MainViewController()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ModulesKt")))
@interface ComposeAppModulesKt : ComposeAppBase
@property (class, readonly) ComposeAppKoin_coreModule *sharedModule __attribute__((swift_name("sharedModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Modules_nativeKt")))
@interface ComposeAppModules_nativeKt : ComposeAppBase
@property (class, readonly) ComposeAppKoin_coreModule *platformModule __attribute__((swift_name("platformModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ResultKt")))
@interface ComposeAppResultKt : ComposeAppBase
+ (id<ComposeAppResult>)asEmptyDataResult:(id<ComposeAppResult>)receiver __attribute__((swift_name("asEmptyDataResult(_:)")));
+ (id<ComposeAppResult>)map:(id<ComposeAppResult>)receiver map:(id _Nullable (^)(id _Nullable))map __attribute__((swift_name("map(_:map:)")));
+ (id<ComposeAppResult>)onError:(id<ComposeAppResult>)receiver action:(void (^)(id<ComposeAppError>))action __attribute__((swift_name("onError(_:action:)")));
+ (id<ComposeAppResult>)onSuccess:(id<ComposeAppResult>)receiver action:(void (^)(id _Nullable))action __attribute__((swift_name("onSuccess(_:action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("WeatherRepoImplKt")))
@interface ComposeAppWeatherRepoImplKt : ComposeAppBase
+ (ComposeAppKtor_client_coreHttpClient *)createHttpClientEngine:(id<ComposeAppKtor_client_coreHttpClientEngine>)engine __attribute__((swift_name("createHttpClient(engine:)")));
@property (class, readonly) NSString *BASE_URL __attribute__((swift_name("BASE_URL")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface ComposeAppKotlinThrowable : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (ComposeAppKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface ComposeAppKotlinException : ComposeAppKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface ComposeAppKotlinRuntimeException : ComposeAppKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface ComposeAppKotlinIllegalStateException : ComposeAppKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface ComposeAppKotlinCancellationException : ComposeAppKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol ComposeAppKotlinx_coroutines_coreFlow
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<ComposeAppKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol ComposeAppKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<ComposeAppKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end

__attribute__((swift_name("Ktor_ioCloseable")))
@protocol ComposeAppKtor_ioCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClient")))
@interface ComposeAppKtor_client_coreHttpClient : ComposeAppBase <ComposeAppKotlinx_coroutines_coreCoroutineScope, ComposeAppKtor_ioCloseable>
- (instancetype)initWithEngine:(id<ComposeAppKtor_client_coreHttpClientEngine>)engine userConfig:(ComposeAppKtor_client_coreHttpClientConfig<ComposeAppKtor_client_coreHttpClientEngineConfig *> *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (ComposeAppKtor_client_coreHttpClient *)configBlock:(void (^)(ComposeAppKtor_client_coreHttpClientConfig<id> *))block __attribute__((swift_name("config(block:)")));
- (BOOL)isSupportedCapability:(id<ComposeAppKtor_client_coreHttpClientEngineCapability>)capability __attribute__((swift_name("isSupported(capability:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<ComposeAppKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) id<ComposeAppKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property (readonly) id<ComposeAppKtor_client_coreHttpClientEngine> engine __attribute__((swift_name("engine")));
@property (readonly) ComposeAppKtor_client_coreHttpClientEngineConfig *engineConfig __attribute__((swift_name("engineConfig")));
@property (readonly) ComposeAppKtor_eventsEvents *monitor __attribute__((swift_name("monitor")));
@property (readonly) ComposeAppKtor_client_coreHttpReceivePipeline *receivePipeline __attribute__((swift_name("receivePipeline")));
@property (readonly) ComposeAppKtor_client_coreHttpRequestPipeline *requestPipeline __attribute__((swift_name("requestPipeline")));
@property (readonly) ComposeAppKtor_client_coreHttpResponsePipeline *responsePipeline __attribute__((swift_name("responsePipeline")));
@property (readonly) ComposeAppKtor_client_coreHttpSendPipeline *sendPipeline __attribute__((swift_name("sendPipeline")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface ComposeAppKotlinEnumCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface ComposeAppKotlinArray<T> : ComposeAppBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(ComposeAppInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<ComposeAppKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol ComposeAppKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<ComposeAppKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<ComposeAppKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol ComposeAppKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<ComposeAppKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<ComposeAppKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol ComposeAppKotlinx_serialization_coreKSerializer <ComposeAppKotlinx_serialization_coreSerializationStrategy, ComposeAppKotlinx_serialization_coreDeserializationStrategy>
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="2.0")
*/
__attribute__((swift_name("KotlinAutoCloseable")))
@protocol ComposeAppKotlinAutoCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end

__attribute__((swift_name("PermissionsPermissionsControllerProtocol")))
@protocol ComposeAppPermissionsPermissionsControllerProtocol
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getPermissionStatePermission:(ComposeAppPermissionsPermission *)permission completionHandler:(void (^)(ComposeAppPermissionsPermissionState * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getPermissionState(permission:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)isPermissionGrantedPermission:(ComposeAppPermissionsPermission *)permission completionHandler:(void (^)(ComposeAppBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("isPermissionGranted(permission:completionHandler:)")));
- (void)openAppSettings __attribute__((swift_name("openAppSettings()")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)providePermissionPermission:(ComposeAppPermissionsPermission *)permission completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("providePermission(permission:completionHandler:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSharedFlow")))
@protocol ComposeAppKotlinx_coroutines_coreSharedFlow <ComposeAppKotlinx_coroutines_coreFlow>
@required
@property (readonly) NSArray<id> *replayCache __attribute__((swift_name("replayCache")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreStateFlow")))
@protocol ComposeAppKotlinx_coroutines_coreStateFlow <ComposeAppKotlinx_coroutines_coreSharedFlow>
@required
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoinApplication")))
@interface ComposeAppKoin_coreKoinApplication : ComposeAppBase
@property (class, readonly, getter=companion) ComposeAppKoin_coreKoinApplicationCompanion *companion __attribute__((swift_name("companion")));
- (void)allowOverrideOverride:(BOOL)override __attribute__((swift_name("allowOverride(override:)")));
- (void)close __attribute__((swift_name("close()")));
- (void)createEagerInstances __attribute__((swift_name("createEagerInstances()")));
- (ComposeAppKoin_coreKoinApplication *)loggerLogger:(ComposeAppKoin_coreLogger *)logger __attribute__((swift_name("logger(logger:)")));
- (ComposeAppKoin_coreKoinApplication *)modulesModules:(ComposeAppKotlinArray<ComposeAppKoin_coreModule *> *)modules __attribute__((swift_name("modules(modules:)")));
- (ComposeAppKoin_coreKoinApplication *)modulesModules_:(NSArray<ComposeAppKoin_coreModule *> *)modules __attribute__((swift_name("modules(modules_:)")));
- (ComposeAppKoin_coreKoinApplication *)modulesModules__:(ComposeAppKoin_coreModule *)modules __attribute__((swift_name("modules(modules__:)")));
- (ComposeAppKoin_coreKoinApplication *)printLoggerLevel:(ComposeAppKoin_coreLevel *)level __attribute__((swift_name("printLogger(level:)")));
- (ComposeAppKoin_coreKoinApplication *)propertiesValues:(NSDictionary<NSString *, id> *)values __attribute__((swift_name("properties(values:)")));
@property (readonly) ComposeAppKoin_coreKoin *koin __attribute__((swift_name("koin")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreModule")))
@interface ComposeAppKoin_coreModule : ComposeAppBase
- (instancetype)initWith_createdAtStart:(BOOL)_createdAtStart __attribute__((swift_name("init(_createdAtStart:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (ComposeAppKoin_coreKoinDefinition<id> *)factoryQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(ComposeAppKoin_coreScope *, ComposeAppKoin_coreParametersHolder *))definition __attribute__((swift_name("factory(qualifier:definition:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (void)includesModule:(ComposeAppKotlinArray<ComposeAppKoin_coreModule *> *)module __attribute__((swift_name("includes(module:)")));
- (void)includesModule_:(id)module __attribute__((swift_name("includes(module_:)")));
- (void)indexPrimaryTypeInstanceFactory:(ComposeAppKoin_coreInstanceFactory<id> *)instanceFactory __attribute__((swift_name("indexPrimaryType(instanceFactory:)")));
- (void)indexSecondaryTypesInstanceFactory:(ComposeAppKoin_coreInstanceFactory<id> *)instanceFactory __attribute__((swift_name("indexSecondaryTypes(instanceFactory:)")));
- (NSArray<ComposeAppKoin_coreModule *> *)plusModules:(NSArray<ComposeAppKoin_coreModule *> *)modules __attribute__((swift_name("plus(modules:)")));
- (NSArray<ComposeAppKoin_coreModule *> *)plusModule:(ComposeAppKoin_coreModule *)module __attribute__((swift_name("plus(module:)")));
- (void)prepareForCreationAtStartInstanceFactory:(ComposeAppKoin_coreSingleInstanceFactory<id> *)instanceFactory __attribute__((swift_name("prepareForCreationAtStart(instanceFactory:)")));
- (void)scopeScopeSet:(void (^)(ComposeAppKoin_coreScopeDSL *))scopeSet __attribute__((swift_name("scope(scopeSet:)")));
- (void)scopeQualifier:(id<ComposeAppKoin_coreQualifier>)qualifier scopeSet:(void (^)(ComposeAppKoin_coreScopeDSL *))scopeSet __attribute__((swift_name("scope(qualifier:scopeSet:)")));
- (ComposeAppKoin_coreKoinDefinition<id> *)singleQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier createdAtStart:(BOOL)createdAtStart definition:(id _Nullable (^)(ComposeAppKoin_coreScope *, ComposeAppKoin_coreParametersHolder *))definition __attribute__((swift_name("single(qualifier:createdAtStart:definition:)")));
@property (readonly) ComposeAppMutableSet<ComposeAppKoin_coreSingleInstanceFactory<id> *> *eagerInstances __attribute__((swift_name("eagerInstances")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) NSMutableArray<ComposeAppKoin_coreModule *> *includedModules __attribute__((swift_name("includedModules")));
@property (readonly) BOOL isLoaded __attribute__((swift_name("isLoaded")));
@property (readonly) ComposeAppMutableDictionary<NSString *, ComposeAppKoin_coreInstanceFactory<id> *> *mappings __attribute__((swift_name("mappings")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientEngine")))
@protocol ComposeAppKtor_client_coreHttpClientEngine <ComposeAppKotlinx_coroutines_coreCoroutineScope, ComposeAppKtor_ioCloseable>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeData:(ComposeAppKtor_client_coreHttpRequestData *)data completionHandler:(void (^)(ComposeAppKtor_client_coreHttpResponseData * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(data:completionHandler:)")));
- (void)installClient:(ComposeAppKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
@property (readonly) ComposeAppKtor_client_coreHttpClientEngineConfig *config __attribute__((swift_name("config")));
@property (readonly) ComposeAppKotlinx_coroutines_coreCoroutineDispatcher *dispatcher __attribute__((swift_name("dispatcher")));
@property (readonly) NSSet<id<ComposeAppKtor_client_coreHttpClientEngineCapability>> *supportedCapabilities __attribute__((swift_name("supportedCapabilities")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol ComposeAppKotlinx_coroutines_coreFlowCollector
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinCoroutineContext")))
@protocol ComposeAppKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<ComposeAppKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<ComposeAppKotlinCoroutineContextElement> _Nullable)getKey:(id<ComposeAppKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<ComposeAppKotlinCoroutineContext>)minusKeyKey:(id<ComposeAppKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<ComposeAppKotlinCoroutineContext>)plusContext:(id<ComposeAppKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientEngineConfig")))
@interface ComposeAppKtor_client_coreHttpClientEngineConfig : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property BOOL pipelining __attribute__((swift_name("pipelining")));
@property ComposeAppKtor_client_coreProxyConfig * _Nullable proxy __attribute__((swift_name("proxy")));
@property int32_t threadsCount __attribute__((swift_name("threadsCount"))) __attribute__((deprecated("The [threadsCount] property is deprecated. The [Dispatchers.IO] is used by default.")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientConfig")))
@interface ComposeAppKtor_client_coreHttpClientConfig<T> : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (ComposeAppKtor_client_coreHttpClientConfig<T> *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(void (^)(T))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(ComposeAppKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installPlugin:(id<ComposeAppKtor_client_coreHttpClientPlugin>)plugin configure:(void (^)(id))configure __attribute__((swift_name("install(plugin:configure:)")));
- (void)installKey:(NSString *)key block:(void (^)(ComposeAppKtor_client_coreHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(ComposeAppKtor_client_coreHttpClientConfig<T> *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL developmentMode __attribute__((swift_name("developmentMode")));
@property BOOL expectSuccess __attribute__((swift_name("expectSuccess")));
@property BOOL followRedirects __attribute__((swift_name("followRedirects")));
@property BOOL useDefaultTransformers __attribute__((swift_name("useDefaultTransformers")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientEngineCapability")))
@protocol ComposeAppKtor_client_coreHttpClientEngineCapability
@required
@end

__attribute__((swift_name("Ktor_utilsAttributes")))
@protocol ComposeAppKtor_utilsAttributes
@required
- (id)computeIfAbsentKey:(ComposeAppKtor_utilsAttributeKey<id> *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(ComposeAppKtor_utilsAttributeKey<id> *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<ComposeAppKtor_utilsAttributeKey<id> *> *allKeys __attribute__((swift_name("allKeys")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_eventsEvents")))
@interface ComposeAppKtor_eventsEvents : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)raiseDefinition:(ComposeAppKtor_eventsEventDefinition<id> *)definition value:(id _Nullable)value __attribute__((swift_name("raise(definition:value:)")));
- (id<ComposeAppKotlinx_coroutines_coreDisposableHandle>)subscribeDefinition:(ComposeAppKtor_eventsEventDefinition<id> *)definition handler:(void (^)(id _Nullable))handler __attribute__((swift_name("subscribe(definition:handler:)")));
- (void)unsubscribeDefinition:(ComposeAppKtor_eventsEventDefinition<id> *)definition handler:(void (^)(id _Nullable))handler __attribute__((swift_name("unsubscribe(definition:handler:)")));
@end

__attribute__((swift_name("Ktor_utilsPipeline")))
@interface ComposeAppKtor_utilsPipeline<TSubject, TContext> : ComposeAppBase
- (instancetype)initWithPhases:(ComposeAppKotlinArray<ComposeAppKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(ComposeAppKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<ComposeAppKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(ComposeAppKtor_utilsPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeContext:(TContext)context subject:(TSubject)subject completionHandler:(void (^)(TSubject _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(context:subject:completionHandler:)")));
- (void)insertPhaseAfterReference:(ComposeAppKtor_utilsPipelinePhase *)reference phase:(ComposeAppKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(ComposeAppKtor_utilsPipelinePhase *)reference phase:(ComposeAppKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(ComposeAppKtor_utilsPipelinePhase *)phase block:(id<ComposeAppKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (NSArray<id<ComposeAppKotlinSuspendFunction2>> *)interceptorsForPhasePhase:(ComposeAppKtor_utilsPipelinePhase *)phase __attribute__((swift_name("interceptorsForPhase(phase:)")));
- (void)mergeFrom:(ComposeAppKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("merge(from:)")));
- (void)mergePhasesFrom:(ComposeAppKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("mergePhases(from:)")));
- (void)resetFromFrom:(ComposeAppKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("resetFrom(from:)")));
@property (readonly) id<ComposeAppKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@property (readonly) BOOL isEmpty __attribute__((swift_name("isEmpty")));
@property (readonly) NSArray<ComposeAppKtor_utilsPipelinePhase *> *items __attribute__((swift_name("items")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline")))
@interface ComposeAppKtor_client_coreHttpReceivePipeline : ComposeAppKtor_utilsPipeline<ComposeAppKtor_client_coreHttpResponse *, ComposeAppKotlinUnit *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(ComposeAppKotlinArray<ComposeAppKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhase:(ComposeAppKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<ComposeAppKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_client_coreHttpReceivePipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline")))
@interface ComposeAppKtor_client_coreHttpRequestPipeline : ComposeAppKtor_utilsPipeline<id, ComposeAppKtor_client_coreHttpRequestBuilder *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(ComposeAppKotlinArray<ComposeAppKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhase:(ComposeAppKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<ComposeAppKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_client_coreHttpRequestPipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline")))
@interface ComposeAppKtor_client_coreHttpResponsePipeline : ComposeAppKtor_utilsPipeline<ComposeAppKtor_client_coreHttpResponseContainer *, ComposeAppKtor_client_coreHttpClientCall *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(ComposeAppKotlinArray<ComposeAppKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhase:(ComposeAppKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<ComposeAppKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_client_coreHttpResponsePipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline")))
@interface ComposeAppKtor_client_coreHttpSendPipeline : ComposeAppKtor_utilsPipeline<id, ComposeAppKtor_client_coreHttpRequestBuilder *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(ComposeAppKotlinArray<ComposeAppKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhase:(ComposeAppKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<ComposeAppKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_client_coreHttpSendPipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol ComposeAppKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol ComposeAppKotlinx_serialization_coreEncoder
@required
- (id<ComposeAppKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<ComposeAppKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<ComposeAppKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol ComposeAppKotlinx_serialization_coreSerialDescriptor
@required

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSArray<id<ComposeAppKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSArray<id<ComposeAppKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) ComposeAppKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol ComposeAppKotlinx_serialization_coreDecoder
@required
- (id<ComposeAppKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<ComposeAppKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (ComposeAppKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PermissionsPermission")))
@interface ComposeAppPermissionsPermission : ComposeAppKotlinEnum<ComposeAppPermissionsPermission *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppPermissionsPermission *camera __attribute__((swift_name("camera")));
@property (class, readonly) ComposeAppPermissionsPermission *gallery __attribute__((swift_name("gallery")));
@property (class, readonly) ComposeAppPermissionsPermission *storage __attribute__((swift_name("storage")));
@property (class, readonly) ComposeAppPermissionsPermission *writeStorage __attribute__((swift_name("writeStorage")));
@property (class, readonly) ComposeAppPermissionsPermission *location __attribute__((swift_name("location")));
@property (class, readonly) ComposeAppPermissionsPermission *coarseLocation __attribute__((swift_name("coarseLocation")));
@property (class, readonly) ComposeAppPermissionsPermission *backgroundLocation __attribute__((swift_name("backgroundLocation")));
@property (class, readonly) ComposeAppPermissionsPermission *bluetoothLe __attribute__((swift_name("bluetoothLe")));
@property (class, readonly) ComposeAppPermissionsPermission *remoteNotification __attribute__((swift_name("remoteNotification")));
@property (class, readonly) ComposeAppPermissionsPermission *recordAudio __attribute__((swift_name("recordAudio")));
@property (class, readonly) ComposeAppPermissionsPermission *bluetoothScan __attribute__((swift_name("bluetoothScan")));
@property (class, readonly) ComposeAppPermissionsPermission *bluetoothAdvertise __attribute__((swift_name("bluetoothAdvertise")));
@property (class, readonly) ComposeAppPermissionsPermission *bluetoothConnect __attribute__((swift_name("bluetoothConnect")));
@property (class, readonly) ComposeAppPermissionsPermission *contacts __attribute__((swift_name("contacts")));
@property (class, readonly) ComposeAppPermissionsPermission *motion __attribute__((swift_name("motion")));
+ (ComposeAppKotlinArray<ComposeAppPermissionsPermission *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppPermissionsPermission *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PermissionsPermissionState")))
@interface ComposeAppPermissionsPermissionState : ComposeAppKotlinEnum<ComposeAppPermissionsPermissionState *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppPermissionsPermissionState *notdetermined __attribute__((swift_name("notdetermined")));
@property (class, readonly) ComposeAppPermissionsPermissionState *notgranted __attribute__((swift_name("notgranted")));
@property (class, readonly) ComposeAppPermissionsPermissionState *granted __attribute__((swift_name("granted")));
@property (class, readonly) ComposeAppPermissionsPermissionState *denied __attribute__((swift_name("denied")));
@property (class, readonly) ComposeAppPermissionsPermissionState *deniedalways __attribute__((swift_name("deniedalways")));
+ (ComposeAppKotlinArray<ComposeAppPermissionsPermissionState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppPermissionsPermissionState *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoinApplication.Companion")))
@interface ComposeAppKoin_coreKoinApplicationCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKoin_coreKoinApplicationCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKoin_coreKoinApplication *)doInit __attribute__((swift_name("doInit()")));
@end

__attribute__((swift_name("Koin_coreLogger")))
@interface ComposeAppKoin_coreLogger : ComposeAppBase
- (instancetype)initWithLevel:(ComposeAppKoin_coreLevel *)level __attribute__((swift_name("init(level:)"))) __attribute__((objc_designated_initializer));
- (void)debugMsg:(NSString *)msg __attribute__((swift_name("debug(msg:)")));
- (void)displayLevel:(ComposeAppKoin_coreLevel *)level msg:(NSString *)msg __attribute__((swift_name("display(level:msg:)")));
- (void)errorMsg:(NSString *)msg __attribute__((swift_name("error(msg:)")));
- (void)infoMsg:(NSString *)msg __attribute__((swift_name("info(msg:)")));
- (BOOL)isAtLvl:(ComposeAppKoin_coreLevel *)lvl __attribute__((swift_name("isAt(lvl:)")));
- (void)logLvl:(ComposeAppKoin_coreLevel *)lvl msg:(NSString *(^)(void))msg __attribute__((swift_name("log(lvl:msg:)")));
- (void)logLvl:(ComposeAppKoin_coreLevel *)lvl msg_:(NSString *)msg __attribute__((swift_name("log(lvl:msg_:)")));
- (void)warnMsg:(NSString *)msg __attribute__((swift_name("warn(msg:)")));
@property ComposeAppKoin_coreLevel *level __attribute__((swift_name("level")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreLevel")))
@interface ComposeAppKoin_coreLevel : ComposeAppKotlinEnum<ComposeAppKoin_coreLevel *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppKoin_coreLevel *debug __attribute__((swift_name("debug")));
@property (class, readonly) ComposeAppKoin_coreLevel *info __attribute__((swift_name("info")));
@property (class, readonly) ComposeAppKoin_coreLevel *warning __attribute__((swift_name("warning")));
@property (class, readonly) ComposeAppKoin_coreLevel *error __attribute__((swift_name("error")));
@property (class, readonly) ComposeAppKoin_coreLevel *none __attribute__((swift_name("none")));
+ (ComposeAppKotlinArray<ComposeAppKoin_coreLevel *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppKoin_coreLevel *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoin")))
@interface ComposeAppKoin_coreKoin : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)close __attribute__((swift_name("close()")));
- (void)createEagerInstances __attribute__((swift_name("createEagerInstances()")));
- (ComposeAppKoin_coreScope *)createScopeT:(id<ComposeAppKoin_coreKoinScopeComponent>)t __attribute__((swift_name("createScope(t:)")));
- (ComposeAppKoin_coreScope *)createScopeScopeId:(NSString *)scopeId __attribute__((swift_name("createScope(scopeId:)")));
- (ComposeAppKoin_coreScope *)createScopeScopeId:(NSString *)scopeId source:(id _Nullable)source __attribute__((swift_name("createScope(scopeId:source:)")));
- (ComposeAppKoin_coreScope *)createScopeScopeId:(NSString *)scopeId qualifier:(id<ComposeAppKoin_coreQualifier>)qualifier source:(id _Nullable)source __attribute__((swift_name("createScope(scopeId:qualifier:source:)")));
- (void)declareInstance:(id _Nullable)instance qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier secondaryTypes:(NSArray<id<ComposeAppKotlinKClass>> *)secondaryTypes allowOverride:(BOOL)allowOverride __attribute__((swift_name("declare(instance:qualifier:secondaryTypes:allowOverride:)")));
- (void)deletePropertyKey:(NSString *)key __attribute__((swift_name("deleteProperty(key:)")));
- (void)deleteScopeScopeId:(NSString *)scopeId __attribute__((swift_name("deleteScope(scopeId:)")));
- (id)getQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(qualifier:parameters:)")));
- (id _Nullable)getClazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(clazz:qualifier:parameters:)")));
- (NSArray<id> *)getAll __attribute__((swift_name("getAll()")));
- (ComposeAppKoin_coreScope *)getOrCreateScopeScopeId:(NSString *)scopeId __attribute__((swift_name("getOrCreateScope(scopeId:)")));
- (ComposeAppKoin_coreScope *)getOrCreateScopeScopeId:(NSString *)scopeId qualifier:(id<ComposeAppKoin_coreQualifier>)qualifier source:(id _Nullable)source __attribute__((swift_name("getOrCreateScope(scopeId:qualifier:source:)")));
- (id _Nullable)getOrNullQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(qualifier:parameters:)")));
- (id _Nullable)getOrNullClazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(clazz:qualifier:parameters:)")));
- (id _Nullable)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (id)getPropertyKey:(NSString *)key defaultValue:(id)defaultValue __attribute__((swift_name("getProperty(key:defaultValue:)")));
- (ComposeAppKoin_coreScope *)getScopeScopeId:(NSString *)scopeId __attribute__((swift_name("getScope(scopeId:)")));
- (ComposeAppKoin_coreScope * _Nullable)getScopeOrNullScopeId:(NSString *)scopeId __attribute__((swift_name("getScopeOrNull(scopeId:)")));
- (id<ComposeAppKotlinLazy>)injectQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier mode:(ComposeAppKotlinLazyThreadSafetyMode *)mode parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("inject(qualifier:mode:parameters:)")));
- (id<ComposeAppKotlinLazy>)injectOrNullQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier mode:(ComposeAppKotlinLazyThreadSafetyMode *)mode parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("injectOrNull(qualifier:mode:parameters:)")));
- (void)loadModulesModules:(NSArray<ComposeAppKoin_coreModule *> *)modules allowOverride:(BOOL)allowOverride createEagerInstances:(BOOL)createEagerInstances __attribute__((swift_name("loadModules(modules:allowOverride:createEagerInstances:)")));
- (void)setPropertyKey:(NSString *)key value:(id)value __attribute__((swift_name("setProperty(key:value:)")));
- (void)setupLoggerLogger:(ComposeAppKoin_coreLogger *)logger __attribute__((swift_name("setupLogger(logger:)")));
- (void)unloadModulesModules:(NSArray<ComposeAppKoin_coreModule *> *)modules __attribute__((swift_name("unloadModules(modules:)")));
@property (readonly) ComposeAppKoin_coreExtensionManager *extensionManager __attribute__((swift_name("extensionManager")));
@property (readonly) ComposeAppKoin_coreInstanceRegistry *instanceRegistry __attribute__((swift_name("instanceRegistry")));
@property (readonly) ComposeAppKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) ComposeAppKoin_corePropertyRegistry *propertyRegistry __attribute__((swift_name("propertyRegistry")));
@property (readonly) ComposeAppKoin_coreScopeRegistry *scopeRegistry __attribute__((swift_name("scopeRegistry")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoinDefinition")))
@interface ComposeAppKoin_coreKoinDefinition<R> : ComposeAppBase
- (instancetype)initWithModule:(ComposeAppKoin_coreModule *)module factory:(ComposeAppKoin_coreInstanceFactory<R> *)factory __attribute__((swift_name("init(module:factory:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKoin_coreKoinDefinition<R> *)doCopyModule:(ComposeAppKoin_coreModule *)module factory:(ComposeAppKoin_coreInstanceFactory<R> *)factory __attribute__((swift_name("doCopy(module:factory:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppKoin_coreInstanceFactory<R> *factory __attribute__((swift_name("factory")));
@property (readonly) ComposeAppKoin_coreModule *module __attribute__((swift_name("module")));
@end

__attribute__((swift_name("Koin_coreQualifier")))
@protocol ComposeAppKoin_coreQualifier
@required
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Koin_coreLockable")))
@interface ComposeAppKoin_coreLockable : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScope")))
@interface ComposeAppKoin_coreScope : ComposeAppKoin_coreLockable
- (instancetype)initWithScopeQualifier:(id<ComposeAppKoin_coreQualifier>)scopeQualifier id:(NSString *)id isRoot:(BOOL)isRoot _koin:(ComposeAppKoin_coreKoin *)_koin __attribute__((swift_name("init(scopeQualifier:id:isRoot:_koin:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)close __attribute__((swift_name("close()")));
- (void)declareInstance:(id _Nullable)instance qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier secondaryTypes:(NSArray<id<ComposeAppKotlinKClass>> *)secondaryTypes allowOverride:(BOOL)allowOverride holdInstance:(BOOL)holdInstance __attribute__((swift_name("declare(instance:qualifier:secondaryTypes:allowOverride:holdInstance:)")));
- (id)getQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(qualifier:parameters:)")));
- (id _Nullable)getClazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(clazz:qualifier:parameters:)")));
- (NSArray<id> *)getAll __attribute__((swift_name("getAll()")));
- (NSArray<id> *)getAllClazz:(id<ComposeAppKotlinKClass>)clazz __attribute__((swift_name("getAll(clazz:)")));
- (ComposeAppKoin_coreKoin *)getKoin __attribute__((swift_name("getKoin()")));
- (id _Nullable)getOrNullQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(qualifier:parameters:)")));
- (id _Nullable)getOrNullClazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(clazz:qualifier:parameters:)")));
- (id)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (id)getPropertyKey:(NSString *)key defaultValue:(id)defaultValue __attribute__((swift_name("getProperty(key:defaultValue:)")));
- (id _Nullable)getPropertyOrNullKey:(NSString *)key __attribute__((swift_name("getPropertyOrNull(key:)")));
- (ComposeAppKoin_coreScope *)getScopeScopeID:(NSString *)scopeID __attribute__((swift_name("getScope(scopeID:)")));
- (id _Nullable)getSource __attribute__((swift_name("getSource()")));
- (id _Nullable)getWithParametersClazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder * _Nullable)parameters __attribute__((swift_name("getWithParameters(clazz:qualifier:parameters:)")));
- (id<ComposeAppKotlinLazy>)injectQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier mode:(ComposeAppKotlinLazyThreadSafetyMode *)mode parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("inject(qualifier:mode:parameters:)")));
- (id<ComposeAppKotlinLazy>)injectOrNullQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier mode:(ComposeAppKotlinLazyThreadSafetyMode *)mode parameters:(ComposeAppKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("injectOrNull(qualifier:mode:parameters:)")));
- (BOOL)isNotClosed __attribute__((swift_name("isNotClosed()")));
- (void)linkToScopes:(ComposeAppKotlinArray<ComposeAppKoin_coreScope *> *)scopes __attribute__((swift_name("linkTo(scopes:)")));
- (void)registerCallbackCallback:(id<ComposeAppKoin_coreScopeCallback>)callback __attribute__((swift_name("registerCallback(callback:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (void)unlinkScopes:(ComposeAppKotlinArray<ComposeAppKoin_coreScope *> *)scopes __attribute__((swift_name("unlink(scopes:)")));
@property (readonly) BOOL closed __attribute__((swift_name("closed")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) BOOL isRoot __attribute__((swift_name("isRoot")));
@property (readonly) ComposeAppKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) id<ComposeAppKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@property id _Nullable sourceValue __attribute__((swift_name("sourceValue")));
@end

__attribute__((swift_name("Koin_coreParametersHolder")))
@interface ComposeAppKoin_coreParametersHolder : ComposeAppBase
- (instancetype)initWith_values:(NSMutableArray<id> *)_values useIndexedValues:(ComposeAppBoolean * _Nullable)useIndexedValues __attribute__((swift_name("init(_values:useIndexedValues:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKoin_coreParametersHolder *)addValue:(id)value __attribute__((swift_name("add(value:)")));
- (id _Nullable)component1 __attribute__((swift_name("component1()")));
- (id _Nullable)component2 __attribute__((swift_name("component2()")));
- (id _Nullable)component3 __attribute__((swift_name("component3()")));
- (id _Nullable)component4 __attribute__((swift_name("component4()")));
- (id _Nullable)component5 __attribute__((swift_name("component5()")));
- (id _Nullable)elementAtI:(int32_t)i clazz:(id<ComposeAppKotlinKClass>)clazz __attribute__((swift_name("elementAt(i:clazz:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (id)get __attribute__((swift_name("get()")));
- (id _Nullable)getI:(int32_t)i __attribute__((swift_name("get(i:)")));
- (id _Nullable)getOrNull __attribute__((swift_name("getOrNull()")));
- (id _Nullable)getOrNullClazz:(id<ComposeAppKotlinKClass>)clazz __attribute__((swift_name("getOrNull(clazz:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (ComposeAppKoin_coreParametersHolder *)insertIndex:(int32_t)index value:(id)value __attribute__((swift_name("insert(index:value:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (BOOL)isNotEmpty __attribute__((swift_name("isNotEmpty()")));
- (void)setI:(int32_t)i t:(id _Nullable)t __attribute__((swift_name("set(i:t:)")));
- (int32_t)size __attribute__((swift_name("size()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property int32_t index __attribute__((swift_name("index")));
@property (readonly) ComposeAppBoolean * _Nullable useIndexedValues __attribute__((swift_name("useIndexedValues")));
@property (readonly) NSArray<id> *values __attribute__((swift_name("values")));
@end

__attribute__((swift_name("Koin_coreInstanceFactory")))
@interface ComposeAppKoin_coreInstanceFactory<T> : ComposeAppKoin_coreLockable
- (instancetype)initWithBeanDefinition:(ComposeAppKoin_coreBeanDefinition<T> *)beanDefinition __attribute__((swift_name("init(beanDefinition:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKoin_coreInstanceFactoryCompanion *companion __attribute__((swift_name("companion")));
- (T _Nullable)createContext:(ComposeAppKoin_coreResolutionContext *)context __attribute__((swift_name("create(context:)")));
- (void)dropScope:(ComposeAppKoin_coreScope * _Nullable)scope __attribute__((swift_name("drop(scope:)")));
- (void)dropAll __attribute__((swift_name("dropAll()")));
- (T _Nullable)getContext:(ComposeAppKoin_coreResolutionContext *)context __attribute__((swift_name("get(context:)")));
- (BOOL)isCreatedContext:(ComposeAppKoin_coreResolutionContext * _Nullable)context __attribute__((swift_name("isCreated(context:)")));
@property (readonly) ComposeAppKoin_coreBeanDefinition<T> *beanDefinition __attribute__((swift_name("beanDefinition")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreSingleInstanceFactory")))
@interface ComposeAppKoin_coreSingleInstanceFactory<T> : ComposeAppKoin_coreInstanceFactory<T>
- (instancetype)initWithBeanDefinition:(ComposeAppKoin_coreBeanDefinition<T> *)beanDefinition __attribute__((swift_name("init(beanDefinition:)"))) __attribute__((objc_designated_initializer));
- (T _Nullable)createContext:(ComposeAppKoin_coreResolutionContext *)context __attribute__((swift_name("create(context:)")));
- (void)dropScope:(ComposeAppKoin_coreScope * _Nullable)scope __attribute__((swift_name("drop(scope:)")));
- (void)dropAll __attribute__((swift_name("dropAll()")));
- (T _Nullable)getContext:(ComposeAppKoin_coreResolutionContext *)context __attribute__((swift_name("get(context:)")));
- (BOOL)isCreatedContext:(ComposeAppKoin_coreResolutionContext * _Nullable)context __attribute__((swift_name("isCreated(context:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeDSL")))
@interface ComposeAppKoin_coreScopeDSL : ComposeAppBase
- (instancetype)initWithScopeQualifier:(id<ComposeAppKoin_coreQualifier>)scopeQualifier module:(ComposeAppKoin_coreModule *)module __attribute__((swift_name("init(scopeQualifier:module:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKoin_coreKoinDefinition<id> *)factoryQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(ComposeAppKoin_coreScope *, ComposeAppKoin_coreParametersHolder *))definition __attribute__((swift_name("factory(qualifier:definition:)")));
- (ComposeAppKoin_coreKoinDefinition<id> *)scopedQualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(ComposeAppKoin_coreScope *, ComposeAppKoin_coreParametersHolder *))definition __attribute__((swift_name("scoped(qualifier:definition:)")));
@property (readonly) ComposeAppKoin_coreModule *module __attribute__((swift_name("module")));
@property (readonly) id<ComposeAppKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestData")))
@interface ComposeAppKtor_client_coreHttpRequestData : ComposeAppBase
- (instancetype)initWithUrl:(ComposeAppKtor_httpUrl *)url method:(ComposeAppKtor_httpHttpMethod *)method headers:(id<ComposeAppKtor_httpHeaders>)headers body:(ComposeAppKtor_httpOutgoingContent *)body executionContext:(id<ComposeAppKotlinx_coroutines_coreJob>)executionContext attributes:(id<ComposeAppKtor_utilsAttributes>)attributes __attribute__((swift_name("init(url:method:headers:body:executionContext:attributes:)"))) __attribute__((objc_designated_initializer));
- (id _Nullable)getCapabilityOrNullKey:(id<ComposeAppKtor_client_coreHttpClientEngineCapability>)key __attribute__((swift_name("getCapabilityOrNull(key:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<ComposeAppKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) ComposeAppKtor_httpOutgoingContent *body __attribute__((swift_name("body")));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) id<ComposeAppKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) ComposeAppKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) ComposeAppKtor_httpUrl *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseData")))
@interface ComposeAppKtor_client_coreHttpResponseData : ComposeAppBase
- (instancetype)initWithStatusCode:(ComposeAppKtor_httpHttpStatusCode *)statusCode requestTime:(ComposeAppKtor_utilsGMTDate *)requestTime headers:(id<ComposeAppKtor_httpHeaders>)headers version:(ComposeAppKtor_httpHttpProtocolVersion *)version body:(id)body callContext:(id<ComposeAppKotlinCoroutineContext>)callContext __attribute__((swift_name("init(statusCode:requestTime:headers:version:body:callContext:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id body __attribute__((swift_name("body")));
@property (readonly) id<ComposeAppKotlinCoroutineContext> callContext __attribute__((swift_name("callContext")));
@property (readonly) id<ComposeAppKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) ComposeAppKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) ComposeAppKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *statusCode __attribute__((swift_name("statusCode")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol ComposeAppKotlinCoroutineContextElement <ComposeAppKotlinCoroutineContext>
@required
@property (readonly) id<ComposeAppKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface ComposeAppKotlinAbstractCoroutineContextElement : ComposeAppBase <ComposeAppKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<ComposeAppKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<ComposeAppKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol ComposeAppKotlinContinuationInterceptor <ComposeAppKotlinCoroutineContextElement>
@required
- (id<ComposeAppKotlinContinuation>)interceptContinuationContinuation:(id<ComposeAppKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<ComposeAppKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher")))
@interface ComposeAppKotlinx_coroutines_coreCoroutineDispatcher : ComposeAppKotlinAbstractCoroutineContextElement <ComposeAppKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<ComposeAppKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKotlinx_coroutines_coreCoroutineDispatcherKey *companion __attribute__((swift_name("companion")));
- (void)dispatchContext:(id<ComposeAppKotlinCoroutineContext>)context block:(id<ComposeAppKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<ComposeAppKotlinCoroutineContext>)context block:(id<ComposeAppKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (id<ComposeAppKotlinContinuation>)interceptContinuationContinuation:(id<ComposeAppKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (BOOL)isDispatchNeededContext:(id<ComposeAppKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));

/**
 * @note annotations
 *   kotlinx.coroutines.ExperimentalCoroutinesApi
*/
- (ComposeAppKotlinx_coroutines_coreCoroutineDispatcher *)limitedParallelismParallelism:(int32_t)parallelism __attribute__((swift_name("limitedParallelism(parallelism:)")));
- (ComposeAppKotlinx_coroutines_coreCoroutineDispatcher *)plusOther:(ComposeAppKotlinx_coroutines_coreCoroutineDispatcher *)other __attribute__((swift_name("plus(other:)"))) __attribute__((unavailable("Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")));
- (void)releaseInterceptedContinuationContinuation:(id<ComposeAppKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol ComposeAppKotlinCoroutineContextKey
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreProxyConfig")))
@interface ComposeAppKtor_client_coreProxyConfig : ComposeAppBase
- (instancetype)initWithUrl:(ComposeAppKtor_httpUrl *)url __attribute__((swift_name("init(url:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppKtor_httpUrl *url __attribute__((swift_name("url")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientPlugin")))
@protocol ComposeAppKtor_client_coreHttpClientPlugin
@required
- (void)installPlugin:(id)plugin scope:(ComposeAppKtor_client_coreHttpClient *)scope __attribute__((swift_name("install(plugin:scope:)")));
- (id)prepareBlock:(void (^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) ComposeAppKtor_utilsAttributeKey<id> *key __attribute__((swift_name("key")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsAttributeKey")))
@interface ComposeAppKtor_utilsAttributeKey<T> : ComposeAppBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((swift_name("Ktor_eventsEventDefinition")))
@interface ComposeAppKtor_eventsEventDefinition<T> : ComposeAppBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreDisposableHandle")))
@protocol ComposeAppKotlinx_coroutines_coreDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsPipelinePhase")))
@interface ComposeAppKtor_utilsPipelinePhase : ComposeAppBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((swift_name("KotlinFunction")))
@protocol ComposeAppKotlinFunction
@required
@end

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol ComposeAppKotlinSuspendFunction2 <ComposeAppKotlinFunction>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 p2:(id _Nullable)p2 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:p2:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline.Phases")))
@interface ComposeAppKtor_client_coreHttpReceivePipelinePhases : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_client_coreHttpReceivePipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *After __attribute__((swift_name("After")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@end

__attribute__((swift_name("Ktor_httpHttpMessage")))
@protocol ComposeAppKtor_httpHttpMessage
@required
@property (readonly) id<ComposeAppKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@end

__attribute__((swift_name("Ktor_client_coreHttpResponse")))
@interface ComposeAppKtor_client_coreHttpResponse : ComposeAppBase <ComposeAppKtor_httpHttpMessage, ComposeAppKotlinx_coroutines_coreCoroutineScope>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) id<ComposeAppKtor_ioByteReadChannel> content __attribute__((swift_name("content")));
@property (readonly) ComposeAppKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) ComposeAppKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *status __attribute__((swift_name("status")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface ComposeAppKotlinUnit : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline.Phases")))
@interface ComposeAppKtor_client_coreHttpRequestPipelinePhases : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_client_coreHttpRequestPipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Render __attribute__((swift_name("Render")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Send __attribute__((swift_name("Send")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Transform __attribute__((swift_name("Transform")));
@end

__attribute__((swift_name("Ktor_httpHttpMessageBuilder")))
@protocol ComposeAppKtor_httpHttpMessageBuilder
@required
@property (readonly) ComposeAppKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder")))
@interface ComposeAppKtor_client_coreHttpRequestBuilder : ComposeAppBase <ComposeAppKtor_httpHttpMessageBuilder>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) ComposeAppKtor_client_coreHttpRequestBuilderCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKtor_client_coreHttpRequestData *)build __attribute__((swift_name("build()")));
- (id _Nullable)getCapabilityOrNullKey:(id<ComposeAppKtor_client_coreHttpClientEngineCapability>)key __attribute__((swift_name("getCapabilityOrNull(key:)")));
- (void)setAttributesBlock:(void (^)(id<ComposeAppKtor_utilsAttributes>))block __attribute__((swift_name("setAttributes(block:)")));
- (void)setCapabilityKey:(id<ComposeAppKtor_client_coreHttpClientEngineCapability>)key capability:(id)capability __attribute__((swift_name("setCapability(key:capability:)")));
- (ComposeAppKtor_client_coreHttpRequestBuilder *)takeFromBuilder:(ComposeAppKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFrom(builder:)")));
- (ComposeAppKtor_client_coreHttpRequestBuilder *)takeFromWithExecutionContextBuilder:(ComposeAppKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFromWithExecutionContext(builder:)")));
- (void)urlBlock:(void (^)(ComposeAppKtor_httpURLBuilder *, ComposeAppKtor_httpURLBuilder *))block __attribute__((swift_name("url(block:)")));
@property (readonly) id<ComposeAppKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property id body __attribute__((swift_name("body")));
@property ComposeAppKtor_utilsTypeInfo * _Nullable bodyType __attribute__((swift_name("bodyType")));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) ComposeAppKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@property ComposeAppKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) ComposeAppKtor_httpURLBuilder *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline.Phases")))
@interface ComposeAppKtor_client_coreHttpResponsePipelinePhases : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_client_coreHttpResponsePipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *After __attribute__((swift_name("After")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Parse __attribute__((swift_name("Parse")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Receive __attribute__((swift_name("Receive")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Transform __attribute__((swift_name("Transform")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseContainer")))
@interface ComposeAppKtor_client_coreHttpResponseContainer : ComposeAppBase
- (instancetype)initWithExpectedType:(ComposeAppKtor_utilsTypeInfo *)expectedType response:(id)response __attribute__((swift_name("init(expectedType:response:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKtor_client_coreHttpResponseContainer *)doCopyExpectedType:(ComposeAppKtor_utilsTypeInfo *)expectedType response:(id)response __attribute__((swift_name("doCopy(expectedType:response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) ComposeAppKtor_utilsTypeInfo *expectedType __attribute__((swift_name("expectedType")));
@property (readonly) id response __attribute__((swift_name("response")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientCall")))
@interface ComposeAppKtor_client_coreHttpClientCall : ComposeAppBase <ComposeAppKotlinx_coroutines_coreCoroutineScope>
- (instancetype)initWithClient:(ComposeAppKtor_client_coreHttpClient *)client __attribute__((swift_name("init(client:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithClient:(ComposeAppKtor_client_coreHttpClient *)client requestData:(ComposeAppKtor_client_coreHttpRequestData *)requestData responseData:(ComposeAppKtor_client_coreHttpResponseData *)responseData __attribute__((swift_name("init(client:requestData:responseData:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_client_coreHttpClientCallCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)bodyInfo:(ComposeAppKtor_utilsTypeInfo *)info completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("body(info:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)bodyNullableInfo:(ComposeAppKtor_utilsTypeInfo *)info completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("bodyNullable(info:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)getResponseContentWithCompletionHandler:(void (^)(id<ComposeAppKtor_ioByteReadChannel> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getResponseContent(completionHandler:)")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) BOOL allowDoubleReceive __attribute__((swift_name("allowDoubleReceive")));
@property (readonly) id<ComposeAppKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) ComposeAppKtor_client_coreHttpClient *client __attribute__((swift_name("client")));
@property (readonly) id<ComposeAppKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property id<ComposeAppKtor_client_coreHttpRequest> request __attribute__((swift_name("request")));
@property ComposeAppKtor_client_coreHttpResponse *response __attribute__((swift_name("response")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline.Phases")))
@interface ComposeAppKtor_client_coreHttpSendPipelinePhases : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_client_coreHttpSendPipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Engine __attribute__((swift_name("Engine")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Monitoring __attribute__((swift_name("Monitoring")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *Receive __attribute__((swift_name("Receive")));
@property (readonly) ComposeAppKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol ComposeAppKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<ComposeAppKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface ComposeAppKotlinx_serialization_coreSerializersModule : ComposeAppBase

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<ComposeAppKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<ComposeAppKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<ComposeAppKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ComposeAppKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<ComposeAppKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<ComposeAppKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol ComposeAppKotlinAnnotation
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface ComposeAppKotlinx_serialization_coreSerialKind : ComposeAppBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol ComposeAppKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<ComposeAppKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<ComposeAppKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) ComposeAppKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface ComposeAppKotlinNothing : ComposeAppBase
@end

__attribute__((swift_name("Koin_coreKoinComponent")))
@protocol ComposeAppKoin_coreKoinComponent
@required
- (ComposeAppKoin_coreKoin *)getKoin __attribute__((swift_name("getKoin()")));
@end

__attribute__((swift_name("Koin_coreKoinScopeComponent")))
@protocol ComposeAppKoin_coreKoinScopeComponent <ComposeAppKoin_coreKoinComponent>
@required
@property (readonly) ComposeAppKoin_coreScope *scope __attribute__((swift_name("scope")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol ComposeAppKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol ComposeAppKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol ComposeAppKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol ComposeAppKotlinKClass <ComposeAppKotlinKDeclarationContainer, ComposeAppKotlinKAnnotatedElement, ComposeAppKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end

__attribute__((swift_name("KotlinLazy")))
@protocol ComposeAppKotlinLazy
@required
- (BOOL)isInitialized __attribute__((swift_name("isInitialized()")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinLazyThreadSafetyMode")))
@interface ComposeAppKotlinLazyThreadSafetyMode : ComposeAppKotlinEnum<ComposeAppKotlinLazyThreadSafetyMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppKotlinLazyThreadSafetyMode *synchronized __attribute__((swift_name("synchronized")));
@property (class, readonly) ComposeAppKotlinLazyThreadSafetyMode *publication __attribute__((swift_name("publication")));
@property (class, readonly) ComposeAppKotlinLazyThreadSafetyMode *none __attribute__((swift_name("none")));
+ (ComposeAppKotlinArray<ComposeAppKotlinLazyThreadSafetyMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppKotlinLazyThreadSafetyMode *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreExtensionManager")))
@interface ComposeAppKoin_coreExtensionManager : ComposeAppBase
- (instancetype)initWith_koin:(ComposeAppKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (id<ComposeAppKoin_coreKoinExtension>)getExtensionId:(NSString *)id __attribute__((swift_name("getExtension(id:)")));
- (id<ComposeAppKoin_coreKoinExtension> _Nullable)getExtensionOrNullId:(NSString *)id __attribute__((swift_name("getExtensionOrNull(id:)")));
- (void)registerExtensionId:(NSString *)id extension:(id<ComposeAppKoin_coreKoinExtension>)extension __attribute__((swift_name("registerExtension(id:extension:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceRegistry")))
@interface ComposeAppKoin_coreInstanceRegistry : ComposeAppBase
- (instancetype)initWith_koin:(ComposeAppKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)saveMappingAllowOverride:(BOOL)allowOverride mapping:(NSString *)mapping factory:(ComposeAppKoin_coreInstanceFactory<id> *)factory logWarning:(BOOL)logWarning __attribute__((swift_name("saveMapping(allowOverride:mapping:factory:logWarning:)")));
- (int32_t)size __attribute__((swift_name("size()")));
@property (readonly) ComposeAppKoin_coreKoin *_koin __attribute__((swift_name("_koin")));
@property (readonly) NSDictionary<NSString *, ComposeAppKoin_coreInstanceFactory<id> *> *instances __attribute__((swift_name("instances")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_corePropertyRegistry")))
@interface ComposeAppKoin_corePropertyRegistry : ComposeAppBase
- (instancetype)initWith_koin:(ComposeAppKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (void)deletePropertyKey:(NSString *)key __attribute__((swift_name("deleteProperty(key:)")));
- (id _Nullable)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (void)savePropertiesProperties:(NSDictionary<NSString *, id> *)properties __attribute__((swift_name("saveProperties(properties:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeRegistry")))
@interface ComposeAppKoin_coreScopeRegistry : ComposeAppBase
- (instancetype)initWith_koin:(ComposeAppKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKoin_coreScopeRegistryCompanion *companion __attribute__((swift_name("companion")));
- (void)loadScopesModules:(NSSet<ComposeAppKoin_coreModule *> *)modules __attribute__((swift_name("loadScopes(modules:)")));
@property (readonly) ComposeAppKoin_coreScope *rootScope __attribute__((swift_name("rootScope")));
@property (readonly) NSSet<id<ComposeAppKoin_coreQualifier>> *scopeDefinitions __attribute__((swift_name("scopeDefinitions")));
@end

__attribute__((swift_name("Koin_coreScopeCallback")))
@protocol ComposeAppKoin_coreScopeCallback
@required
- (void)onScopeCloseScope:(ComposeAppKoin_coreScope *)scope __attribute__((swift_name("onScopeClose(scope:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreBeanDefinition")))
@interface ComposeAppKoin_coreBeanDefinition<T> : ComposeAppBase
- (instancetype)initWithScopeQualifier:(id<ComposeAppKoin_coreQualifier>)scopeQualifier primaryType:(id<ComposeAppKotlinKClass>)primaryType qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier definition:(T _Nullable (^)(ComposeAppKoin_coreScope *, ComposeAppKoin_coreParametersHolder *))definition kind:(ComposeAppKoin_coreKind *)kind secondaryTypes:(NSArray<id<ComposeAppKotlinKClass>> *)secondaryTypes __attribute__((swift_name("init(scopeQualifier:primaryType:qualifier:definition:kind:secondaryTypes:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (BOOL)hasTypeClazz:(id<ComposeAppKotlinKClass>)clazz __attribute__((swift_name("hasType(clazz:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isClazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier scopeDefinition:(id<ComposeAppKoin_coreQualifier>)scopeDefinition __attribute__((swift_name("is(clazz:qualifier:scopeDefinition:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property ComposeAppKoin_coreCallbacks<T> *callbacks __attribute__((swift_name("callbacks")));
@property (readonly) T _Nullable (^definition)(ComposeAppKoin_coreScope *, ComposeAppKoin_coreParametersHolder *) __attribute__((swift_name("definition")));
@property (readonly) ComposeAppKoin_coreKind *kind __attribute__((swift_name("kind")));
@property (readonly) id<ComposeAppKotlinKClass> primaryType __attribute__((swift_name("primaryType")));
@property id<ComposeAppKoin_coreQualifier> _Nullable qualifier __attribute__((swift_name("qualifier")));
@property (readonly) id<ComposeAppKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@property NSArray<id<ComposeAppKotlinKClass>> *secondaryTypes __attribute__((swift_name("secondaryTypes")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceFactoryCompanion")))
@interface ComposeAppKoin_coreInstanceFactoryCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKoin_coreInstanceFactoryCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *ERROR_SEPARATOR __attribute__((swift_name("ERROR_SEPARATOR")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreResolutionContext")))
@interface ComposeAppKoin_coreResolutionContext : ComposeAppBase
- (instancetype)initWithLogger:(ComposeAppKoin_coreLogger *)logger scope:(ComposeAppKoin_coreScope *)scope clazz:(id<ComposeAppKotlinKClass>)clazz qualifier:(id<ComposeAppKoin_coreQualifier> _Nullable)qualifier parameters:(ComposeAppKoin_coreParametersHolder * _Nullable)parameters __attribute__((swift_name("init(logger:scope:clazz:qualifier:parameters:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<ComposeAppKotlinKClass> clazz __attribute__((swift_name("clazz")));
@property (readonly) NSString *debugTag __attribute__((swift_name("debugTag")));
@property (readonly) ComposeAppKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) ComposeAppKoin_coreParametersHolder * _Nullable parameters __attribute__((swift_name("parameters")));
@property (readonly) id<ComposeAppKoin_coreQualifier> _Nullable qualifier __attribute__((swift_name("qualifier")));
@property (readonly) ComposeAppKoin_coreScope *scope __attribute__((swift_name("scope")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl")))
@interface ComposeAppKtor_httpUrl : ComposeAppBase
@property (class, readonly, getter=companion) ComposeAppKtor_httpUrlCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *encodedFragment __attribute__((swift_name("encodedFragment")));
@property (readonly) NSString * _Nullable encodedPassword __attribute__((swift_name("encodedPassword")));
@property (readonly) NSString *encodedPath __attribute__((swift_name("encodedPath")));
@property (readonly) NSString *encodedPathAndQuery __attribute__((swift_name("encodedPathAndQuery")));
@property (readonly) NSString *encodedQuery __attribute__((swift_name("encodedQuery")));
@property (readonly) NSString * _Nullable encodedUser __attribute__((swift_name("encodedUser")));
@property (readonly) NSString *fragment __attribute__((swift_name("fragment")));
@property (readonly) NSString *host __attribute__((swift_name("host")));
@property (readonly) id<ComposeAppKtor_httpParameters> parameters __attribute__((swift_name("parameters")));
@property (readonly) NSString * _Nullable password __attribute__((swift_name("password")));
@property (readonly) NSArray<NSString *> *pathSegments __attribute__((swift_name("pathSegments")));
@property (readonly) int32_t port __attribute__((swift_name("port")));
@property (readonly) ComposeAppKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property (readonly) int32_t specifiedPort __attribute__((swift_name("specifiedPort")));
@property (readonly) BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property (readonly) NSString * _Nullable user __attribute__((swift_name("user")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod")))
@interface ComposeAppKtor_httpHttpMethod : ComposeAppBase
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_httpHttpMethodCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKtor_httpHttpMethod *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Ktor_utilsStringValues")))
@protocol ComposeAppKtor_utilsStringValues
@required
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<ComposeAppKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (void)forEachBody:(void (^)(NSString *, NSArray<NSString *> *))body __attribute__((swift_name("forEach(body:)")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty_ __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end

__attribute__((swift_name("Ktor_httpHeaders")))
@protocol ComposeAppKtor_httpHeaders <ComposeAppKtor_utilsStringValues>
@required
@end

__attribute__((swift_name("Ktor_httpOutgoingContent")))
@interface ComposeAppKtor_httpOutgoingContent : ComposeAppBase
- (id _Nullable)getPropertyKey:(ComposeAppKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getProperty(key:)")));
- (void)setPropertyKey:(ComposeAppKtor_utilsAttributeKey<id> *)key value:(id _Nullable)value __attribute__((swift_name("setProperty(key:value:)")));
- (id<ComposeAppKtor_httpHeaders> _Nullable)trailers __attribute__((swift_name("trailers()")));
@property (readonly) ComposeAppLong * _Nullable contentLength __attribute__((swift_name("contentLength")));
@property (readonly) ComposeAppKtor_httpContentType * _Nullable contentType __attribute__((swift_name("contentType")));
@property (readonly) id<ComposeAppKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode * _Nullable status __attribute__((swift_name("status")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreJob")))
@protocol ComposeAppKotlinx_coroutines_coreJob <ComposeAppKotlinCoroutineContextElement>
@required
- (id<ComposeAppKotlinx_coroutines_coreChildHandle>)attachChildChild:(id<ComposeAppKotlinx_coroutines_coreChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancelCause:(ComposeAppKotlinCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (ComposeAppKotlinCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<ComposeAppKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionHandler:(void (^)(ComposeAppKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));
- (id<ComposeAppKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(void (^)(ComposeAppKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)joinWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("join(completionHandler:)")));
- (id<ComposeAppKotlinx_coroutines_coreJob>)plusOther_:(id<ComposeAppKotlinx_coroutines_coreJob>)other __attribute__((swift_name("plus(other_:)"))) __attribute__((unavailable("Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")));
- (BOOL)start __attribute__((swift_name("start()")));
@property (readonly) id<ComposeAppKotlinSequence> children __attribute__((swift_name("children")));
@property (readonly) BOOL isActive __attribute__((swift_name("isActive")));
@property (readonly) BOOL isCancelled __attribute__((swift_name("isCancelled")));
@property (readonly) BOOL isCompleted __attribute__((swift_name("isCompleted")));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreSelectClause0> onJoin __attribute__((swift_name("onJoin")));

/**
 * @note annotations
 *   kotlinx.coroutines.ExperimentalCoroutinesApi
*/
@property (readonly) id<ComposeAppKotlinx_coroutines_coreJob> _Nullable parent __attribute__((swift_name("parent")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode")))
@interface ComposeAppKtor_httpHttpStatusCode : ComposeAppBase <ComposeAppKotlinComparable>
- (instancetype)initWithValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("init(value:description:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_httpHttpStatusCodeCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(ComposeAppKtor_httpHttpStatusCode *)other __attribute__((swift_name("compareTo(other:)")));
- (ComposeAppKtor_httpHttpStatusCode *)doCopyValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("doCopy(value:description:)")));
- (ComposeAppKtor_httpHttpStatusCode *)descriptionValue:(NSString *)value __attribute__((swift_name("description(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@property (readonly) int32_t value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate")))
@interface ComposeAppKtor_utilsGMTDate : ComposeAppBase <ComposeAppKotlinComparable>
@property (class, readonly, getter=companion) ComposeAppKtor_utilsGMTDateCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(ComposeAppKtor_utilsGMTDate *)other __attribute__((swift_name("compareTo(other:)")));
- (ComposeAppKtor_utilsGMTDate *)doCopySeconds:(int32_t)seconds minutes:(int32_t)minutes hours:(int32_t)hours dayOfWeek:(ComposeAppKtor_utilsWeekDay *)dayOfWeek dayOfMonth:(int32_t)dayOfMonth dayOfYear:(int32_t)dayOfYear month:(ComposeAppKtor_utilsMonth *)month year:(int32_t)year timestamp:(int64_t)timestamp __attribute__((swift_name("doCopy(seconds:minutes:hours:dayOfWeek:dayOfMonth:dayOfYear:month:year:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) ComposeAppKtor_utilsWeekDay *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) int32_t hours __attribute__((swift_name("hours")));
@property (readonly) int32_t minutes __attribute__((swift_name("minutes")));
@property (readonly) ComposeAppKtor_utilsMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t seconds __attribute__((swift_name("seconds")));
@property (readonly) int64_t timestamp __attribute__((swift_name("timestamp")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion")))
@interface ComposeAppKtor_httpHttpProtocolVersion : ComposeAppBase
- (instancetype)initWithName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("init(name:major:minor:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_httpHttpProtocolVersionCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKtor_httpHttpProtocolVersion *)doCopyName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("doCopy(name:major:minor:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t major __attribute__((swift_name("major")));
@property (readonly) int32_t minor __attribute__((swift_name("minor")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinContinuation")))
@protocol ComposeAppKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<ComposeAppKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
 *   kotlin.ExperimentalStdlibApi
*/
__attribute__((swift_name("KotlinAbstractCoroutineContextKey")))
@interface ComposeAppKotlinAbstractCoroutineContextKey<B, E> : ComposeAppBase <ComposeAppKotlinCoroutineContextKey>
- (instancetype)initWithBaseKey:(id<ComposeAppKotlinCoroutineContextKey>)baseKey safeCast:(E _Nullable (^)(id<ComposeAppKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.ExperimentalStdlibApi
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher.Key")))
@interface ComposeAppKotlinx_coroutines_coreCoroutineDispatcherKey : ComposeAppKotlinAbstractCoroutineContextKey<id<ComposeAppKotlinContinuationInterceptor>, ComposeAppKotlinx_coroutines_coreCoroutineDispatcher *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithBaseKey:(id<ComposeAppKotlinCoroutineContextKey>)baseKey safeCast:(id<ComposeAppKotlinCoroutineContextElement> _Nullable (^)(id<ComposeAppKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)key __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKotlinx_coroutines_coreCoroutineDispatcherKey *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreRunnable")))
@protocol ComposeAppKotlinx_coroutines_coreRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end

__attribute__((swift_name("Ktor_ioByteReadChannel")))
@protocol ComposeAppKtor_ioByteReadChannel
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)awaitContentWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("awaitContent(completionHandler:)")));
- (BOOL)cancelCause_:(ComposeAppKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)discardMax:(int64_t)max completionHandler:(void (^)(ComposeAppLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("discard(max:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)peekToDestination:(ComposeAppKtor_ioMemory *)destination destinationOffset:(int64_t)destinationOffset offset:(int64_t)offset min:(int64_t)min max:(int64_t)max completionHandler:(void (^)(ComposeAppLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("peekTo(destination:destinationOffset:offset:min:max:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(ComposeAppKtor_ioChunkBuffer *)dst completionHandler:(void (^)(ComposeAppInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:completionHandler:)")));
- (int32_t)readAvailableMin:(int32_t)min block:(void (^)(ComposeAppKtor_ioBuffer *))block __attribute__((swift_name("readAvailable(min:block:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(ComposeAppKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length completionHandler:(void (^)(ComposeAppInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(void *)dst offset:(int32_t)offset length:(int32_t)length completionHandler_:(void (^)(ComposeAppInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(void *)dst offset:(int64_t)offset length:(int64_t)length completionHandler__:(void (^)(ComposeAppInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler__:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readBooleanWithCompletionHandler:(void (^)(ComposeAppBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readBoolean(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readByteWithCompletionHandler:(void (^)(ComposeAppByte * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readByte(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readDoubleWithCompletionHandler:(void (^)(ComposeAppDouble * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readDouble(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFloatWithCompletionHandler:(void (^)(ComposeAppFloat * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readFloat(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(ComposeAppKtor_ioChunkBuffer *)dst n:(int32_t)n completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:n:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(ComposeAppKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(void *)dst offset:(int32_t)offset length:(int32_t)length completionHandler_:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(void *)dst offset:(int64_t)offset length:(int64_t)length completionHandler__:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler__:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readIntWithCompletionHandler:(void (^)(ComposeAppInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readInt(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readLongWithCompletionHandler:(void (^)(ComposeAppLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readLong(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readPacketSize:(int32_t)size completionHandler:(void (^)(ComposeAppKtor_ioByteReadPacket * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readPacket(size:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readRemainingLimit:(int64_t)limit completionHandler:(void (^)(ComposeAppKtor_ioByteReadPacket * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readRemaining(limit:completionHandler:)")));
- (void)readSessionConsumer:(void (^)(id<ComposeAppKtor_ioReadSession>))consumer __attribute__((swift_name("readSession(consumer:)"))) __attribute__((deprecated("Use read { } instead.")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readShortWithCompletionHandler:(void (^)(ComposeAppShort * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readShort(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readSuspendableSessionConsumer:(id<ComposeAppKotlinSuspendFunction1>)consumer completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readSuspendableSession(consumer:completionHandler:)"))) __attribute__((deprecated("Use read { } instead.")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readUTF8LineLimit:(int32_t)limit completionHandler:(void (^)(NSString * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("readUTF8Line(limit:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readUTF8LineToOut:(id<ComposeAppKotlinAppendable>)out limit:(int32_t)limit completionHandler:(void (^)(ComposeAppBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readUTF8LineTo(out:limit:completionHandler:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@property (readonly) ComposeAppKotlinThrowable * _Nullable closedCause __attribute__((swift_name("closedCause")));
@property (readonly) BOOL isClosedForRead __attribute__((swift_name("isClosedForRead")));
@property (readonly) BOOL isClosedForWrite __attribute__((swift_name("isClosedForWrite")));
@property (readonly) int64_t totalBytesRead __attribute__((swift_name("totalBytesRead")));
@end

__attribute__((swift_name("Ktor_utilsStringValuesBuilder")))
@protocol ComposeAppKtor_utilsStringValuesBuilder
@required
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<ComposeAppKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<ComposeAppKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<ComposeAppKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<ComposeAppKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty_ __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end

__attribute__((swift_name("Ktor_utilsStringValuesBuilderImpl")))
@interface ComposeAppKtor_utilsStringValuesBuilderImpl : ComposeAppBase <ComposeAppKtor_utilsStringValuesBuilder>
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer));
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<ComposeAppKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<ComposeAppKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<ComposeAppKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<ComposeAppKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty_ __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateNameName:(NSString *)name __attribute__((swift_name("validateName(name:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateValueValue:(NSString *)value __attribute__((swift_name("validateValue(value:)")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) ComposeAppMutableDictionary<NSString *, NSMutableArray<NSString *> *> *values __attribute__((swift_name("values")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeadersBuilder")))
@interface ComposeAppKtor_httpHeadersBuilder : ComposeAppKtor_utilsStringValuesBuilderImpl
- (instancetype)initWithSize:(int32_t)size __attribute__((swift_name("init(size:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<ComposeAppKtor_httpHeaders>)build __attribute__((swift_name("build()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateNameName:(NSString *)name __attribute__((swift_name("validateName(name:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateValueValue:(NSString *)value __attribute__((swift_name("validateValue(value:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder.Companion")))
@interface ComposeAppKtor_client_coreHttpRequestBuilderCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_client_coreHttpRequestBuilderCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder")))
@interface ComposeAppKtor_httpURLBuilder : ComposeAppBase
- (instancetype)initWithProtocol:(ComposeAppKtor_httpURLProtocol *)protocol host:(NSString *)host port:(int32_t)port user:(NSString * _Nullable)user password:(NSString * _Nullable)password pathSegments:(NSArray<NSString *> *)pathSegments parameters:(id<ComposeAppKtor_httpParameters>)parameters fragment:(NSString *)fragment trailingQuery:(BOOL)trailingQuery __attribute__((swift_name("init(protocol:host:port:user:password:pathSegments:parameters:fragment:trailingQuery:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_httpURLBuilderCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKtor_httpUrl *)build __attribute__((swift_name("build()")));
- (NSString *)buildString __attribute__((swift_name("buildString()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property NSString *encodedFragment __attribute__((swift_name("encodedFragment")));
@property id<ComposeAppKtor_httpParametersBuilder> encodedParameters __attribute__((swift_name("encodedParameters")));
@property NSString * _Nullable encodedPassword __attribute__((swift_name("encodedPassword")));
@property NSArray<NSString *> *encodedPathSegments __attribute__((swift_name("encodedPathSegments")));
@property NSString * _Nullable encodedUser __attribute__((swift_name("encodedUser")));
@property NSString *fragment __attribute__((swift_name("fragment")));
@property NSString *host __attribute__((swift_name("host")));
@property (readonly) id<ComposeAppKtor_httpParametersBuilder> parameters __attribute__((swift_name("parameters")));
@property NSString * _Nullable password __attribute__((swift_name("password")));
@property NSArray<NSString *> *pathSegments __attribute__((swift_name("pathSegments")));
@property int32_t port __attribute__((swift_name("port")));
@property ComposeAppKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property NSString * _Nullable user __attribute__((swift_name("user")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsTypeInfo")))
@interface ComposeAppKtor_utilsTypeInfo : ComposeAppBase
- (instancetype)initWithType:(id<ComposeAppKotlinKClass>)type reifiedType:(id<ComposeAppKotlinKType>)reifiedType kotlinType:(id<ComposeAppKotlinKType> _Nullable)kotlinType __attribute__((swift_name("init(type:reifiedType:kotlinType:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKtor_utilsTypeInfo *)doCopyType:(id<ComposeAppKotlinKClass>)type reifiedType:(id<ComposeAppKotlinKType>)reifiedType kotlinType:(id<ComposeAppKotlinKType> _Nullable)kotlinType __attribute__((swift_name("doCopy(type:reifiedType:kotlinType:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<ComposeAppKotlinKType> _Nullable kotlinType __attribute__((swift_name("kotlinType")));
@property (readonly) id<ComposeAppKotlinKType> reifiedType __attribute__((swift_name("reifiedType")));
@property (readonly) id<ComposeAppKotlinKClass> type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientCall.Companion")))
@interface ComposeAppKtor_client_coreHttpClientCallCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_client_coreHttpClientCallCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_utilsAttributeKey<id> *CustomResponse __attribute__((swift_name("CustomResponse"))) __attribute__((unavailable("This is going to be removed. Please file a ticket with clarification why and what for do you need it.")));
@end

__attribute__((swift_name("Ktor_client_coreHttpRequest")))
@protocol ComposeAppKtor_client_coreHttpRequest <ComposeAppKtor_httpHttpMessage, ComposeAppKotlinx_coroutines_coreCoroutineScope>
@required
@property (readonly) id<ComposeAppKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) ComposeAppKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) ComposeAppKtor_httpOutgoingContent *content __attribute__((swift_name("content")));
@property (readonly) ComposeAppKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) ComposeAppKtor_httpUrl *url __attribute__((swift_name("url")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol ComposeAppKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<ComposeAppKotlinKClass>)kClass provider:(id<ComposeAppKotlinx_serialization_coreKSerializer> (^)(NSArray<id<ComposeAppKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<ComposeAppKotlinKClass>)kClass serializer:(id<ComposeAppKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<ComposeAppKotlinKClass>)baseClass actualClass:(id<ComposeAppKotlinKClass>)actualClass actualSerializer:(id<ComposeAppKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<ComposeAppKotlinKClass>)baseClass defaultDeserializerProvider:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<ComposeAppKotlinKClass>)baseClass defaultDeserializerProvider:(id<ComposeAppKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<ComposeAppKotlinKClass>)baseClass defaultSerializerProvider:(id<ComposeAppKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end

__attribute__((swift_name("Koin_coreKoinExtension")))
@protocol ComposeAppKoin_coreKoinExtension
@required
- (void)onClose __attribute__((swift_name("onClose()")));
- (void)onRegisterKoin:(ComposeAppKoin_coreKoin *)koin __attribute__((swift_name("onRegister(koin:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeRegistry.Companion")))
@interface ComposeAppKoin_coreScopeRegistryCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKoin_coreScopeRegistryCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKind")))
@interface ComposeAppKoin_coreKind : ComposeAppKotlinEnum<ComposeAppKoin_coreKind *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppKoin_coreKind *singleton __attribute__((swift_name("singleton")));
@property (class, readonly) ComposeAppKoin_coreKind *factory __attribute__((swift_name("factory")));
@property (class, readonly) ComposeAppKoin_coreKind *scoped __attribute__((swift_name("scoped")));
+ (ComposeAppKotlinArray<ComposeAppKoin_coreKind *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppKoin_coreKind *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreCallbacks")))
@interface ComposeAppKoin_coreCallbacks<T> : ComposeAppBase
- (instancetype)initWithOnClose:(void (^ _Nullable)(T _Nullable))onClose __attribute__((swift_name("init(onClose:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKoin_coreCallbacks<T> *)doCopyOnClose:(void (^ _Nullable)(T _Nullable))onClose __attribute__((swift_name("doCopy(onClose:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) void (^ _Nullable onClose)(T _Nullable) __attribute__((swift_name("onClose")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl.Companion")))
@interface ComposeAppKtor_httpUrlCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpUrlCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("Ktor_httpParameters")))
@protocol ComposeAppKtor_httpParameters <ComposeAppKtor_utilsStringValues>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol")))
@interface ComposeAppKtor_httpURLProtocol : ComposeAppBase
- (instancetype)initWithName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("init(name:defaultPort:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_httpURLProtocolCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKtor_httpURLProtocol *)doCopyName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("doCopy(name:defaultPort:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t defaultPort __attribute__((swift_name("defaultPort")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod.Companion")))
@interface ComposeAppKtor_httpHttpMethodCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpHttpMethodCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_httpHttpMethod *)parseMethod:(NSString *)method __attribute__((swift_name("parse(method:)")));
@property (readonly) NSArray<ComposeAppKtor_httpHttpMethod *> *DefaultMethods __attribute__((swift_name("DefaultMethods")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Delete __attribute__((swift_name("Delete")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Get __attribute__((swift_name("Get")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Head __attribute__((swift_name("Head")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Options __attribute__((swift_name("Options")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Patch __attribute__((swift_name("Patch")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Post __attribute__((swift_name("Post")));
@property (readonly) ComposeAppKtor_httpHttpMethod *Put __attribute__((swift_name("Put")));
@end

__attribute__((swift_name("KotlinMapEntry")))
@protocol ComposeAppKotlinMapEntry
@required
@property (readonly) id _Nullable key __attribute__((swift_name("key")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Ktor_httpHeaderValueWithParameters")))
@interface ComposeAppKtor_httpHeaderValueWithParameters : ComposeAppBase
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<ComposeAppKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_httpHeaderValueWithParametersCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)parameterName:(NSString *)name __attribute__((swift_name("parameter(name:)")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) NSString *content __attribute__((swift_name("content")));
@property (readonly) NSArray<ComposeAppKtor_httpHeaderValueParam *> *parameters __attribute__((swift_name("parameters")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType")))
@interface ComposeAppKtor_httpContentType : ComposeAppKtor_httpHeaderValueWithParameters
- (instancetype)initWithContentType:(NSString *)contentType contentSubtype:(NSString *)contentSubtype parameters:(NSArray<ComposeAppKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(contentType:contentSubtype:parameters:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<ComposeAppKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_httpContentTypeCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)matchPattern:(ComposeAppKtor_httpContentType *)pattern __attribute__((swift_name("match(pattern:)")));
- (BOOL)matchPattern_:(NSString *)pattern __attribute__((swift_name("match(pattern_:)")));
- (ComposeAppKtor_httpContentType *)withParameterName:(NSString *)name value:(NSString *)value __attribute__((swift_name("withParameter(name:value:)")));
- (ComposeAppKtor_httpContentType *)withoutParameters __attribute__((swift_name("withoutParameters()")));
@property (readonly) NSString *contentSubtype __attribute__((swift_name("contentSubtype")));
@property (readonly) NSString *contentType __attribute__((swift_name("contentType")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreChildHandle")))
@protocol ComposeAppKotlinx_coroutines_coreChildHandle <ComposeAppKotlinx_coroutines_coreDisposableHandle>
@required
- (BOOL)childCancelledCause:(ComposeAppKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@property (readonly) id<ComposeAppKotlinx_coroutines_coreJob> _Nullable parent __attribute__((swift_name("parent")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreChildJob")))
@protocol ComposeAppKotlinx_coroutines_coreChildJob <ComposeAppKotlinx_coroutines_coreJob>
@required
- (void)parentCancelledParentJob:(id<ComposeAppKotlinx_coroutines_coreParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
@end

__attribute__((swift_name("KotlinSequence")))
@protocol ComposeAppKotlinSequence
@required
- (id<ComposeAppKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause")))
@protocol ComposeAppKotlinx_coroutines_coreSelectClause
@required
@property (readonly) id clauseObject __attribute__((swift_name("clauseObject")));
@property (readonly) ComposeAppKotlinUnit *(^(^ _Nullable onCancellationConstructor)(id<ComposeAppKotlinx_coroutines_coreSelectInstance>, id _Nullable, id _Nullable))(ComposeAppKotlinThrowable *) __attribute__((swift_name("onCancellationConstructor")));
@property (readonly) id _Nullable (^processResFunc)(id, id _Nullable, id _Nullable) __attribute__((swift_name("processResFunc")));
@property (readonly) void (^regFunc)(id, id<ComposeAppKotlinx_coroutines_coreSelectInstance>, id _Nullable) __attribute__((swift_name("regFunc")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause0")))
@protocol ComposeAppKotlinx_coroutines_coreSelectClause0 <ComposeAppKotlinx_coroutines_coreSelectClause>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode.Companion")))
@interface ComposeAppKtor_httpHttpStatusCodeCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpHttpStatusCodeCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_httpHttpStatusCode *)fromValueValue:(int32_t)value __attribute__((swift_name("fromValue(value:)")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Accepted __attribute__((swift_name("Accepted")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *BadGateway __attribute__((swift_name("BadGateway")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *BadRequest __attribute__((swift_name("BadRequest")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Conflict __attribute__((swift_name("Conflict")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Continue __attribute__((swift_name("Continue")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Created __attribute__((swift_name("Created")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *ExpectationFailed __attribute__((swift_name("ExpectationFailed")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *FailedDependency __attribute__((swift_name("FailedDependency")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Forbidden __attribute__((swift_name("Forbidden")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Found __attribute__((swift_name("Found")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *GatewayTimeout __attribute__((swift_name("GatewayTimeout")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Gone __attribute__((swift_name("Gone")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *InsufficientStorage __attribute__((swift_name("InsufficientStorage")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *InternalServerError __attribute__((swift_name("InternalServerError")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *LengthRequired __attribute__((swift_name("LengthRequired")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Locked __attribute__((swift_name("Locked")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *MethodNotAllowed __attribute__((swift_name("MethodNotAllowed")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *MovedPermanently __attribute__((swift_name("MovedPermanently")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *MultiStatus __attribute__((swift_name("MultiStatus")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *MultipleChoices __attribute__((swift_name("MultipleChoices")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *NoContent __attribute__((swift_name("NoContent")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *NonAuthoritativeInformation __attribute__((swift_name("NonAuthoritativeInformation")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *NotAcceptable __attribute__((swift_name("NotAcceptable")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *NotFound __attribute__((swift_name("NotFound")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *NotImplemented __attribute__((swift_name("NotImplemented")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *NotModified __attribute__((swift_name("NotModified")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *OK __attribute__((swift_name("OK")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *PartialContent __attribute__((swift_name("PartialContent")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *PayloadTooLarge __attribute__((swift_name("PayloadTooLarge")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *PaymentRequired __attribute__((swift_name("PaymentRequired")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *PermanentRedirect __attribute__((swift_name("PermanentRedirect")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *PreconditionFailed __attribute__((swift_name("PreconditionFailed")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Processing __attribute__((swift_name("Processing")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *ProxyAuthenticationRequired __attribute__((swift_name("ProxyAuthenticationRequired")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *RequestHeaderFieldTooLarge __attribute__((swift_name("RequestHeaderFieldTooLarge")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *RequestTimeout __attribute__((swift_name("RequestTimeout")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *RequestURITooLong __attribute__((swift_name("RequestURITooLong")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *RequestedRangeNotSatisfiable __attribute__((swift_name("RequestedRangeNotSatisfiable")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *ResetContent __attribute__((swift_name("ResetContent")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *SeeOther __attribute__((swift_name("SeeOther")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *ServiceUnavailable __attribute__((swift_name("ServiceUnavailable")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *SwitchProxy __attribute__((swift_name("SwitchProxy")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *SwitchingProtocols __attribute__((swift_name("SwitchingProtocols")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *TemporaryRedirect __attribute__((swift_name("TemporaryRedirect")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *TooEarly __attribute__((swift_name("TooEarly")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *TooManyRequests __attribute__((swift_name("TooManyRequests")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *Unauthorized __attribute__((swift_name("Unauthorized")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *UnprocessableEntity __attribute__((swift_name("UnprocessableEntity")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *UnsupportedMediaType __attribute__((swift_name("UnsupportedMediaType")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *UpgradeRequired __attribute__((swift_name("UpgradeRequired")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *UseProxy __attribute__((swift_name("UseProxy")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *VariantAlsoNegotiates __attribute__((swift_name("VariantAlsoNegotiates")));
@property (readonly) ComposeAppKtor_httpHttpStatusCode *VersionNotSupported __attribute__((swift_name("VersionNotSupported")));
@property (readonly) NSArray<ComposeAppKtor_httpHttpStatusCode *> *allStatusCodes __attribute__((swift_name("allStatusCodes")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate.Companion")))
@interface ComposeAppKtor_utilsGMTDateCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_utilsGMTDateCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_utilsGMTDate *START __attribute__((swift_name("START")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay")))
@interface ComposeAppKtor_utilsWeekDay : ComposeAppKotlinEnum<ComposeAppKtor_utilsWeekDay *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_utilsWeekDayCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *monday __attribute__((swift_name("monday")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *tuesday __attribute__((swift_name("tuesday")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *wednesday __attribute__((swift_name("wednesday")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *thursday __attribute__((swift_name("thursday")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *friday __attribute__((swift_name("friday")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *saturday __attribute__((swift_name("saturday")));
@property (class, readonly) ComposeAppKtor_utilsWeekDay *sunday __attribute__((swift_name("sunday")));
+ (ComposeAppKotlinArray<ComposeAppKtor_utilsWeekDay *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth")))
@interface ComposeAppKtor_utilsMonth : ComposeAppKotlinEnum<ComposeAppKtor_utilsMonth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_utilsMonthCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) ComposeAppKtor_utilsMonth *january __attribute__((swift_name("january")));
@property (class, readonly) ComposeAppKtor_utilsMonth *february __attribute__((swift_name("february")));
@property (class, readonly) ComposeAppKtor_utilsMonth *march __attribute__((swift_name("march")));
@property (class, readonly) ComposeAppKtor_utilsMonth *april __attribute__((swift_name("april")));
@property (class, readonly) ComposeAppKtor_utilsMonth *may __attribute__((swift_name("may")));
@property (class, readonly) ComposeAppKtor_utilsMonth *june __attribute__((swift_name("june")));
@property (class, readonly) ComposeAppKtor_utilsMonth *july __attribute__((swift_name("july")));
@property (class, readonly) ComposeAppKtor_utilsMonth *august __attribute__((swift_name("august")));
@property (class, readonly) ComposeAppKtor_utilsMonth *september __attribute__((swift_name("september")));
@property (class, readonly) ComposeAppKtor_utilsMonth *october __attribute__((swift_name("october")));
@property (class, readonly) ComposeAppKtor_utilsMonth *november __attribute__((swift_name("november")));
@property (class, readonly) ComposeAppKtor_utilsMonth *december __attribute__((swift_name("december")));
+ (ComposeAppKotlinArray<ComposeAppKtor_utilsMonth *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion.Companion")))
@interface ComposeAppKtor_httpHttpProtocolVersionCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpHttpProtocolVersionCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_httpHttpProtocolVersion *)fromValueName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("fromValue(name:major:minor:)")));
- (ComposeAppKtor_httpHttpProtocolVersion *)parseValue:(id)value __attribute__((swift_name("parse(value:)")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *HTTP_1_0 __attribute__((swift_name("HTTP_1_0")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *HTTP_1_1 __attribute__((swift_name("HTTP_1_1")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *HTTP_2_0 __attribute__((swift_name("HTTP_2_0")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *QUIC __attribute__((swift_name("QUIC")));
@property (readonly) ComposeAppKtor_httpHttpProtocolVersion *SPDY_3 __attribute__((swift_name("SPDY_3")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioMemory")))
@interface ComposeAppKtor_ioMemory : ComposeAppBase
- (instancetype)initWithPointer:(void *)pointer size:(int64_t)size __attribute__((swift_name("init(pointer:size:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKtor_ioMemoryCompanion *companion __attribute__((swift_name("companion")));
- (void)doCopyToDestination:(ComposeAppKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length destinationOffset:(int32_t)destinationOffset __attribute__((swift_name("doCopyTo(destination:offset:length:destinationOffset:)")));
- (void)doCopyToDestination:(ComposeAppKtor_ioMemory *)destination offset:(int64_t)offset length:(int64_t)length destinationOffset_:(int64_t)destinationOffset __attribute__((swift_name("doCopyTo(destination:offset:length:destinationOffset_:)")));
- (int8_t)loadAtIndex:(int32_t)index __attribute__((swift_name("loadAt(index:)")));
- (int8_t)loadAtIndex_:(int64_t)index __attribute__((swift_name("loadAt(index_:)")));
- (ComposeAppKtor_ioMemory *)sliceOffset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("slice(offset:length:)")));
- (ComposeAppKtor_ioMemory *)sliceOffset:(int64_t)offset length_:(int64_t)length __attribute__((swift_name("slice(offset:length_:)")));
- (void)storeAtIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("storeAt(index:value:)")));
- (void)storeAtIndex:(int64_t)index value_:(int8_t)value __attribute__((swift_name("storeAt(index:value_:)")));
@property (readonly) void *pointer __attribute__((swift_name("pointer")));
@property (readonly) int64_t size __attribute__((swift_name("size")));
@property (readonly) int32_t size32 __attribute__((swift_name("size32")));
@end

__attribute__((swift_name("Ktor_ioBuffer")))
@interface ComposeAppKtor_ioBuffer : ComposeAppBase
- (instancetype)initWithMemory:(ComposeAppKtor_ioMemory *)memory __attribute__((swift_name("init(memory:)"))) __attribute__((objc_designated_initializer)) __attribute__((deprecated("\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")));
@property (class, readonly, getter=companion) ComposeAppKtor_ioBufferCompanion *companion __attribute__((swift_name("companion")));
- (void)commitWrittenCount:(int32_t)count __attribute__((swift_name("commitWritten(count:)")));
- (void)discardExactCount:(int32_t)count __attribute__((swift_name("discardExact(count:)")));
- (ComposeAppKtor_ioBuffer *)duplicate __attribute__((swift_name("duplicate()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)duplicateToCopy:(ComposeAppKtor_ioBuffer *)copy __attribute__((swift_name("duplicateTo(copy:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (void)reserveEndGapEndGap:(int32_t)endGap __attribute__((swift_name("reserveEndGap(endGap:)")));
- (void)reserveStartGapStartGap:(int32_t)startGap __attribute__((swift_name("reserveStartGap(startGap:)")));
- (void)reset __attribute__((swift_name("reset()")));
- (void)resetForRead __attribute__((swift_name("resetForRead()")));
- (void)resetForWrite __attribute__((swift_name("resetForWrite()")));
- (void)resetForWriteLimit:(int32_t)limit __attribute__((swift_name("resetForWrite(limit:)")));
- (void)rewindCount:(int32_t)count __attribute__((swift_name("rewind(count:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (int32_t)tryPeekByte __attribute__((swift_name("tryPeekByte()")));
- (int32_t)tryReadByte __attribute__((swift_name("tryReadByte()")));
- (void)writeByteValue:(int8_t)value __attribute__((swift_name("writeByte(value:)")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@property (readonly) int32_t endGap __attribute__((swift_name("endGap")));
@property (readonly) int32_t limit __attribute__((swift_name("limit")));
@property (readonly) ComposeAppKtor_ioMemory *memory __attribute__((swift_name("memory")));
@property (readonly) int32_t readPosition __attribute__((swift_name("readPosition")));
@property (readonly) int32_t readRemaining __attribute__((swift_name("readRemaining")));
@property (readonly) int32_t startGap __attribute__((swift_name("startGap")));
@property (readonly) int32_t writePosition __attribute__((swift_name("writePosition")));
@property (readonly) int32_t writeRemaining __attribute__((swift_name("writeRemaining")));
@end

__attribute__((swift_name("Ktor_ioChunkBuffer")))
@interface ComposeAppKtor_ioChunkBuffer : ComposeAppKtor_ioBuffer
- (instancetype)initWithMemory:(ComposeAppKtor_ioMemory *)memory origin:(ComposeAppKtor_ioChunkBuffer * _Nullable)origin parentPool:(id<ComposeAppKtor_ioObjectPool> _Nullable)parentPool __attribute__((swift_name("init(memory:origin:parentPool:)"))) __attribute__((objc_designated_initializer)) __attribute__((deprecated("\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")));
- (instancetype)initWithMemory:(ComposeAppKtor_ioMemory *)memory __attribute__((swift_name("init(memory:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_ioChunkBufferCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKtor_ioChunkBuffer * _Nullable)cleanNext __attribute__((swift_name("cleanNext()")));
- (ComposeAppKtor_ioChunkBuffer *)duplicate __attribute__((swift_name("duplicate()")));
- (void)releasePool:(id<ComposeAppKtor_ioObjectPool>)pool __attribute__((swift_name("release(pool:)")));
- (void)reset __attribute__((swift_name("reset()")));
@property (getter=next_) ComposeAppKtor_ioChunkBuffer * _Nullable next __attribute__((swift_name("next")));
@property (readonly) ComposeAppKtor_ioChunkBuffer * _Nullable origin __attribute__((swift_name("origin")));
@property (readonly) int32_t referenceCount __attribute__((swift_name("referenceCount")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface ComposeAppKotlinByteArray : ComposeAppBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(ComposeAppByte *(^)(ComposeAppInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (ComposeAppKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("Ktor_ioInput")))
@interface ComposeAppKtor_ioInput : ComposeAppBase <ComposeAppKtor_ioCloseable>
- (instancetype)initWithHead:(ComposeAppKtor_ioChunkBuffer *)head remaining:(int64_t)remaining pool:(id<ComposeAppKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:remaining:pool:)"))) __attribute__((objc_designated_initializer)) __attribute__((deprecated("\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")));
@property (class, readonly, getter=companion) ComposeAppKtor_ioInputCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)canRead __attribute__((swift_name("canRead()")));
- (void)close __attribute__((swift_name("close()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)closeSource __attribute__((swift_name("closeSource()")));
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (int64_t)discardN_:(int64_t)n __attribute__((swift_name("discard(n_:)")));
- (void)discardExactN:(int32_t)n __attribute__((swift_name("discardExact(n:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (ComposeAppKtor_ioChunkBuffer * _Nullable)fill __attribute__((swift_name("fill()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (int32_t)fillDestination:(ComposeAppKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("fill(destination:offset:length:)")));
- (BOOL)hasBytesN:(int32_t)n __attribute__((swift_name("hasBytes(n:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)markNoMoreChunksAvailable __attribute__((swift_name("markNoMoreChunksAvailable()")));
- (int32_t)peekToBuffer:(ComposeAppKtor_ioChunkBuffer *)buffer __attribute__((swift_name("peekTo(buffer:)")));
- (int64_t)peekToDestination:(ComposeAppKtor_ioMemory *)destination destinationOffset:(int64_t)destinationOffset offset:(int64_t)offset min:(int64_t)min max:(int64_t)max __attribute__((swift_name("peekTo(destination:destinationOffset:offset:min:max:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (NSString *)readTextMin:(int32_t)min max:(int32_t)max __attribute__((swift_name("readText(min:max:)")));
- (int32_t)readTextOut:(id<ComposeAppKotlinAppendable>)out min:(int32_t)min max:(int32_t)max __attribute__((swift_name("readText(out:min:max:)")));
- (NSString *)readTextExactExactCharacters:(int32_t)exactCharacters __attribute__((swift_name("readTextExact(exactCharacters:)")));
- (void)readTextExactOut:(id<ComposeAppKotlinAppendable>)out exactCharacters:(int32_t)exactCharacters __attribute__((swift_name("readTextExact(out:exactCharacters:)")));
- (void)release_ __attribute__((swift_name("release()")));
- (int32_t)tryPeek __attribute__((swift_name("tryPeek()")));
@property (readonly) BOOL endOfInput __attribute__((swift_name("endOfInput")));
@property (readonly) id<ComposeAppKtor_ioObjectPool> pool __attribute__((swift_name("pool")));
@property (readonly) int64_t remaining __attribute__((swift_name("remaining")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioByteReadPacket")))
@interface ComposeAppKtor_ioByteReadPacket : ComposeAppKtor_ioInput
- (instancetype)initWithHead:(ComposeAppKtor_ioChunkBuffer *)head pool:(id<ComposeAppKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:pool:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithHead:(ComposeAppKtor_ioChunkBuffer *)head remaining:(int64_t)remaining pool:(id<ComposeAppKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:remaining:pool:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) ComposeAppKtor_ioByteReadPacketCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)closeSource __attribute__((swift_name("closeSource()")));
- (ComposeAppKtor_ioByteReadPacket *)doCopy __attribute__((swift_name("doCopy()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (ComposeAppKtor_ioChunkBuffer * _Nullable)fill __attribute__((swift_name("fill()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (int32_t)fillDestination:(ComposeAppKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("fill(destination:offset:length:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Ktor_ioReadSession")))
@protocol ComposeAppKtor_ioReadSession
@required
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (ComposeAppKtor_ioChunkBuffer * _Nullable)requestAtLeast:(int32_t)atLeast __attribute__((swift_name("request(atLeast:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@end

__attribute__((swift_name("KotlinSuspendFunction1")))
@protocol ComposeAppKotlinSuspendFunction1 <ComposeAppKotlinFunction>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:completionHandler:)")));
@end

__attribute__((swift_name("KotlinAppendable")))
@protocol ComposeAppKotlinAppendable
@required
- (id<ComposeAppKotlinAppendable>)appendValue:(unichar)value __attribute__((swift_name("append(value:)")));
- (id<ComposeAppKotlinAppendable>)appendValue_:(id _Nullable)value __attribute__((swift_name("append(value_:)")));
- (id<ComposeAppKotlinAppendable>)appendValue:(id _Nullable)value startIndex:(int32_t)startIndex endIndex:(int32_t)endIndex __attribute__((swift_name("append(value:startIndex:endIndex:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder.Companion")))
@interface ComposeAppKtor_httpURLBuilderCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpURLBuilderCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("Ktor_httpParametersBuilder")))
@protocol ComposeAppKtor_httpParametersBuilder <ComposeAppKtor_utilsStringValuesBuilder>
@required
@end

__attribute__((swift_name("KotlinKType")))
@protocol ComposeAppKotlinKType
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
@property (readonly) NSArray<ComposeAppKotlinKTypeProjection *> *arguments __attribute__((swift_name("arguments")));

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
@property (readonly) id<ComposeAppKotlinKClassifier> _Nullable classifier __attribute__((swift_name("classifier")));
@property (readonly) BOOL isMarkedNullable __attribute__((swift_name("isMarkedNullable")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol.Companion")))
@interface ComposeAppKtor_httpURLProtocolCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpURLProtocolCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_httpURLProtocol *)createOrDefaultName:(NSString *)name __attribute__((swift_name("createOrDefault(name:)")));
@property (readonly) ComposeAppKtor_httpURLProtocol *HTTP __attribute__((swift_name("HTTP")));
@property (readonly) ComposeAppKtor_httpURLProtocol *HTTPS __attribute__((swift_name("HTTPS")));
@property (readonly) ComposeAppKtor_httpURLProtocol *SOCKS __attribute__((swift_name("SOCKS")));
@property (readonly) ComposeAppKtor_httpURLProtocol *WS __attribute__((swift_name("WS")));
@property (readonly) ComposeAppKtor_httpURLProtocol *WSS __attribute__((swift_name("WSS")));
@property (readonly) NSDictionary<NSString *, ComposeAppKtor_httpURLProtocol *> *byName __attribute__((swift_name("byName")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueParam")))
@interface ComposeAppKtor_httpHeaderValueParam : ComposeAppBase
- (instancetype)initWithName:(NSString *)name value:(NSString *)value __attribute__((swift_name("init(name:value:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithName:(NSString *)name value:(NSString *)value escapeValue:(BOOL)escapeValue __attribute__((swift_name("init(name:value:escapeValue:)"))) __attribute__((objc_designated_initializer));
- (ComposeAppKtor_httpHeaderValueParam *)doCopyName:(NSString *)name value:(NSString *)value escapeValue:(BOOL)escapeValue __attribute__((swift_name("doCopy(name:value:escapeValue:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL escapeValue __attribute__((swift_name("escapeValue")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueWithParameters.Companion")))
@interface ComposeAppKtor_httpHeaderValueWithParametersCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpHeaderValueWithParametersCompanion *shared __attribute__((swift_name("shared")));
- (id _Nullable)parseValue:(NSString *)value init:(id _Nullable (^)(NSString *, NSArray<ComposeAppKtor_httpHeaderValueParam *> *))init __attribute__((swift_name("parse(value:init:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType.Companion")))
@interface ComposeAppKtor_httpContentTypeCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_httpContentTypeCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_httpContentType *)parseValue:(NSString *)value __attribute__((swift_name("parse(value:)")));
@property (readonly) ComposeAppKtor_httpContentType *Any __attribute__((swift_name("Any")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreParentJob")))
@protocol ComposeAppKotlinx_coroutines_coreParentJob <ComposeAppKotlinx_coroutines_coreJob>
@required
- (ComposeAppKotlinCancellationException *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSelectInstance")))
@protocol ComposeAppKotlinx_coroutines_coreSelectInstance
@required
- (void)disposeOnCompletionDisposableHandle:(id<ComposeAppKotlinx_coroutines_coreDisposableHandle>)disposableHandle __attribute__((swift_name("disposeOnCompletion(disposableHandle:)")));
- (void)selectInRegistrationPhaseInternalResult:(id _Nullable)internalResult __attribute__((swift_name("selectInRegistrationPhase(internalResult:)")));
- (BOOL)trySelectClauseObject:(id)clauseObject result:(id _Nullable)result __attribute__((swift_name("trySelect(clauseObject:result:)")));
@property (readonly) id<ComposeAppKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay.Companion")))
@interface ComposeAppKtor_utilsWeekDayCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_utilsWeekDayCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_utilsWeekDay *)fromOrdinal:(int32_t)ordinal __attribute__((swift_name("from(ordinal:)")));
- (ComposeAppKtor_utilsWeekDay *)fromValue:(NSString *)value __attribute__((swift_name("from(value:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth.Companion")))
@interface ComposeAppKtor_utilsMonthCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_utilsMonthCompanion *shared __attribute__((swift_name("shared")));
- (ComposeAppKtor_utilsMonth *)fromOrdinal:(int32_t)ordinal __attribute__((swift_name("from(ordinal:)")));
- (ComposeAppKtor_utilsMonth *)fromValue:(NSString *)value __attribute__((swift_name("from(value:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioMemory.Companion")))
@interface ComposeAppKtor_ioMemoryCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_ioMemoryCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_ioMemory *Empty __attribute__((swift_name("Empty")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioBuffer.Companion")))
@interface ComposeAppKtor_ioBufferCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_ioBufferCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_ioBuffer *Empty __attribute__((swift_name("Empty")));
@property (readonly) int32_t ReservedSize __attribute__((swift_name("ReservedSize")));
@end

__attribute__((swift_name("Ktor_ioObjectPool")))
@protocol ComposeAppKtor_ioObjectPool <ComposeAppKtor_ioCloseable>
@required
- (id)borrow __attribute__((swift_name("borrow()")));
- (void)dispose __attribute__((swift_name("dispose()")));
- (void)recycleInstance:(id)instance __attribute__((swift_name("recycle(instance:)")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioChunkBuffer.Companion")))
@interface ComposeAppKtor_ioChunkBufferCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_ioChunkBufferCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_ioChunkBuffer *Empty __attribute__((swift_name("Empty")));
@property (readonly) id<ComposeAppKtor_ioObjectPool> EmptyPool __attribute__((swift_name("EmptyPool")));
@property (readonly) id<ComposeAppKtor_ioObjectPool> Pool __attribute__((swift_name("Pool")));
@end

__attribute__((swift_name("KotlinByteIterator")))
@interface ComposeAppKotlinByteIterator : ComposeAppBase <ComposeAppKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (ComposeAppByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioInput.Companion")))
@interface ComposeAppKtor_ioInputCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_ioInputCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioByteReadPacket.Companion")))
@interface ComposeAppKtor_ioByteReadPacketCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKtor_ioByteReadPacketCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) ComposeAppKtor_ioByteReadPacket *Empty __attribute__((swift_name("Empty")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKTypeProjection")))
@interface ComposeAppKotlinKTypeProjection : ComposeAppBase
- (instancetype)initWithVariance:(ComposeAppKotlinKVariance * _Nullable)variance type:(id<ComposeAppKotlinKType> _Nullable)type __attribute__((swift_name("init(variance:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) ComposeAppKotlinKTypeProjectionCompanion *companion __attribute__((swift_name("companion")));
- (ComposeAppKotlinKTypeProjection *)doCopyVariance:(ComposeAppKotlinKVariance * _Nullable)variance type:(id<ComposeAppKotlinKType> _Nullable)type __attribute__((swift_name("doCopy(variance:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<ComposeAppKotlinKType> _Nullable type __attribute__((swift_name("type")));
@property (readonly) ComposeAppKotlinKVariance * _Nullable variance __attribute__((swift_name("variance")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKVariance")))
@interface ComposeAppKotlinKVariance : ComposeAppKotlinEnum<ComposeAppKotlinKVariance *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) ComposeAppKotlinKVariance *invariant __attribute__((swift_name("invariant")));
@property (class, readonly) ComposeAppKotlinKVariance *in __attribute__((swift_name("in")));
@property (class, readonly) ComposeAppKotlinKVariance *out __attribute__((swift_name("out")));
+ (ComposeAppKotlinArray<ComposeAppKotlinKVariance *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<ComposeAppKotlinKVariance *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKTypeProjection.Companion")))
@interface ComposeAppKotlinKTypeProjectionCompanion : ComposeAppBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) ComposeAppKotlinKTypeProjectionCompanion *shared __attribute__((swift_name("shared")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (ComposeAppKotlinKTypeProjection *)contravariantType:(id<ComposeAppKotlinKType>)type __attribute__((swift_name("contravariant(type:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (ComposeAppKotlinKTypeProjection *)covariantType:(id<ComposeAppKotlinKType>)type __attribute__((swift_name("covariant(type:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (ComposeAppKotlinKTypeProjection *)invariantType:(id<ComposeAppKotlinKType>)type __attribute__((swift_name("invariant(type:)")));
@property (readonly) ComposeAppKotlinKTypeProjection *STAR __attribute__((swift_name("STAR")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END

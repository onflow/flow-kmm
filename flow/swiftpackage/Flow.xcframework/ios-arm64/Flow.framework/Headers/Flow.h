#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class FlowChainId, FlowChainIdCanary, FlowChainIdCustom, FlowChainIdEmulator, FlowChainIdMainnet, FlowChainIdSandboxnet, FlowChainIdTestnet, FlowCadenceValue, FlowAccount, FlowBlock, FlowBlockHeader, FlowCollection, FlowBlockEvents, FlowExecutionResult, FlowTransaction, FlowTransactionResult, FlowKotlinThrowable, FlowKotlinArray<T>, FlowKotlinException, FlowKotlinRuntimeException, FlowKotlinIllegalArgumentException, FlowRLPType, FlowKotlinByteArray, FlowRLPElement, FlowRLPList, FlowApiBaseCompanion, FlowKtor_client_coreHttpClient, FlowBase64ByteArrayCompanion, FlowBase64ByteArray, FlowBigDecimalCadenceSerializer, FlowBignumBigDecimal, FlowBigIntegerCadenceSerializer, FlowBignumBigInteger, FlowByteCadenceSerializer, FlowCadenceCompanion, FlowCadenceType, FlowCadenceCapabilityCompanion, FlowCadenceCapability, FlowCadenceValueAddressValue, FlowCadenceValueArrayValue, FlowCadenceValueBooleanValue, FlowCadenceValueCapabilityValue, FlowCadenceValueContractValue, FlowCadenceCompositeValue, FlowCadenceValueDictionaryValue, FlowCadenceDictionaryFieldEntry, FlowCadenceValueFix64Value, FlowCadenceValueIntValue, FlowCadenceValueInt128Value, FlowCadenceValueInt16Value, FlowCadenceValueInt256Value, FlowCadenceValueInt32Value, FlowCadenceValueInt64Value, FlowCadenceValueInt8Value, FlowCadenceValueOptionalValue, FlowCadenceValuePathValue, FlowCadencePath, FlowCadencePathDomain, FlowCadenceValueStringValue, FlowCadenceValueStructValue, FlowCadenceValueTypeValue, FlowCadenceKind, FlowCadenceTypeEntry, FlowCadenceValueUFix64Value, FlowCadenceValueUIntValue, FlowCadenceValueUInt128Value, FlowCadenceValueUInt16Value, FlowCadenceValueUInt256Value, FlowCadenceValueUInt32Value, FlowCadenceValueUInt64Value, FlowCadenceValueUInt8Value, FlowCadenceValueVoidValue, FlowCadenceValueWord16Value, FlowCadenceValueWord32Value, FlowCadenceValueWord64Value, FlowCadenceValueWord8Value, FlowCadenceCompositeAttributeCompanion, FlowCadenceCompositeAttribute, FlowCadenceCompositeValueCompanion, FlowKotlinPair<__covariant A, __covariant B>, FlowCadenceDictionaryFieldEntryCompanion, FlowCadenceKindCompanion, FlowCadencePathCompanion, FlowKotlinEnumCompanion, FlowKotlinEnum<E>, FlowCadencePathDomainCompanion, FlowCadenceTypeCompanion, FlowCadenceTypeEntryCompanion, FlowCadenceValueCompanion, FlowCadenceValueAddressValueCompanion, FlowCadenceValueArrayValueCompanion, FlowCadenceValueBooleanValueCompanion, FlowCadenceValueCapabilityValueCompanion, FlowKotlinx_serialization_jsonJsonElement, FlowKotlinx_serialization_jsonJson, FlowCadenceValueContractValueCompanion, FlowCadenceValueDictionaryValueCompanion, FlowCadenceValueEnumValueCompanion, FlowCadenceValueEnumValue, FlowCadenceValueEventValueCompanion, FlowCadenceValueEventValue, FlowCadenceValueFix64ValueCompanion, FlowCadenceValueInt128ValueCompanion, FlowCadenceValueInt16ValueCompanion, FlowCadenceValueInt256ValueCompanion, FlowCadenceValueInt32ValueCompanion, FlowCadenceValueInt64ValueCompanion, FlowCadenceValueInt8ValueCompanion, FlowCadenceValueIntValueCompanion, FlowCadenceValueOptionalValueCompanion, FlowCadenceValuePathValueCompanion, FlowCadenceValueResourceValueCompanion, FlowCadenceValueResourceValue, FlowCadenceValueStringValueCompanion, FlowCadenceValueStructValueCompanion, FlowCadenceValueTypeValueCompanion, FlowCadenceValueUFix64ValueCompanion, FlowCadenceValueUInt128ValueCompanion, FlowCadenceValueUInt16ValueCompanion, FlowCadenceValueUInt256ValueCompanion, FlowCadenceValueUInt32ValueCompanion, FlowCadenceValueUInt64ValueCompanion, FlowCadenceValueUInt8ValueCompanion, FlowCadenceValueUIntValueCompanion, FlowKotlinUnit, FlowCadenceValueVoidValueCompanion, FlowCadenceValueWord16ValueCompanion, FlowCadenceValueWord32ValueCompanion, FlowCadenceValueWord64ValueCompanion, FlowCadenceValueWord8ValueCompanion, FlowCadenceTypeSerializer, FlowDoubleCadenceSerializer, FlowFixedPointFormatter, FlowIntCadenceSerializer, FlowLongCadenceSerializer, FlowShortCadenceSerializer, FlowUByteCadenceSerializer, FlowUIntCadenceSerializer, FlowULongCadenceSerializer, FlowUShortCadenceSerializer, FlowAccountExpandable, FlowAccountPublicKey, FlowLinks, FlowAccountCompanion, FlowAccountExpandableCompanion, FlowSigningAlgorithm, FlowHashingAlgorithm, FlowAccountPublicKeyCompanion, FlowAggregatedSignatureCompanion, FlowAggregatedSignature, FlowBase64HexSerializer, FlowBase64UFT8Serializer, FlowBlockExpandable, FlowBlockPayload, FlowBlockCompanion, FlowEvent, FlowBlockEventsCompanion, FlowBlockExpandableCompanion, FlowBlockHeaderCompanion, FlowBlockHeightOneOfCompanion, FlowBlockHeightOneOf, FlowCollectionGuarantee, FlowBlockSeal, FlowBlockPayloadCompanion, FlowBlockSealCompanion, FlowCadenceBase64Serializer, FlowChunkCompanion, FlowChunk, FlowCollectionExpandable, FlowCollectionCompanion, FlowCollectionExpandableCompanion, FlowCollectionGuaranteeCompanion, FlowCompareTransactionSignatureCompanion, FlowTransactionSignature, FlowDomainTag, FlowDomainTagAccountProof, FlowDomainTagCustom, FlowDomainTagTransaction, FlowDomainTagUser, FlowErrorCompanion, FlowError, FlowEventCompanion, FlowExecutionResultCompanion, FlowHashingAlgorithmCompanion, FlowLinksCompanion, FlowProposalKeyCompanion, FlowProposalKey, FlowScriptsPostRequestCompanion, FlowScriptsPostRequest, FlowScriptsPostResponseCompanion, FlowScriptsPostResponse, FlowSigningAlgorithmCompanion, FlowStringIntSerializer, FlowTransactionExpandable, FlowTransactionCompanion, FlowTransactionExecutionCompanion, FlowTransactionExecution, FlowTransactionExpandableCompanion, FlowTransactionStatus, FlowTransactionResultCompanion, FlowTransactionSignatureCompanion, FlowTransactionStatusCompanion, FlowFlowApi, FlowKotlinByteIterator, FlowBignumBigIntegerCompanion, FlowBignumBigIntegerQuotientAndRemainder, FlowBignumSign, FlowBignumBigIntegerBigIntegerRange, FlowBignumBigIntegerSqareRootAndRemainder, FlowBignumModularBigInteger, FlowKotlinIllegalStateException, FlowKtor_client_coreHttpClientEngineConfig, FlowKtor_client_coreHttpClientConfig<T>, FlowKtor_eventsEvents, FlowKtor_client_coreHttpReceivePipeline, FlowKtor_client_coreHttpRequestPipeline, FlowKtor_client_coreHttpResponsePipeline, FlowKtor_client_coreHttpSendPipeline, FlowKotlinx_serialization_coreSerializersModule, FlowKotlinx_serialization_coreSerialKind, FlowKotlinNothing, FlowBignumBigDecimalCompanion, FlowBignumDecimalMode, FlowBignumRoundingMode, FlowKotlinx_serialization_jsonJsonElementCompanion, FlowKotlinx_serialization_jsonJsonDefault, FlowKotlinx_serialization_jsonJsonConfiguration, FlowBignumModularBigIntegerCompanion, FlowBignumModularQuotientAndRemainder, FlowKtor_client_coreHttpRequestData, FlowKtor_client_coreHttpResponseData, FlowKotlinx_coroutines_coreCoroutineDispatcher, FlowKtor_client_coreProxyConfig, FlowKtor_utilsAttributeKey<T>, FlowKtor_eventsEventDefinition<T>, FlowKtor_utilsPipelinePhase, FlowKtor_utilsPipeline<TSubject, TContext>, FlowKtor_client_coreHttpReceivePipelinePhases, FlowKtor_client_coreHttpResponse, FlowKtor_client_coreHttpRequestPipelinePhases, FlowKtor_client_coreHttpRequestBuilder, FlowKtor_client_coreHttpResponsePipelinePhases, FlowKtor_client_coreHttpResponseContainer, FlowKtor_client_coreHttpClientCall, FlowKtor_client_coreHttpSendPipelinePhases, FlowBignumDecimalModeCompanion, FlowKtor_httpUrl, FlowKtor_httpHttpMethod, FlowKtor_httpOutgoingContent, FlowKtor_httpHttpStatusCode, FlowKtor_utilsGMTDate, FlowKtor_httpHttpProtocolVersion, FlowKotlinAbstractCoroutineContextElement, FlowKotlinx_coroutines_coreCoroutineDispatcherKey, FlowKtor_httpHeadersBuilder, FlowKtor_client_coreHttpRequestBuilderCompanion, FlowKtor_httpURLBuilder, FlowKtor_utilsTypeInfo, FlowKtor_client_coreHttpClientCallCompanion, FlowKtor_httpUrlCompanion, FlowKtor_httpURLProtocol, FlowKtor_httpHttpMethodCompanion, FlowKtor_httpContentType, FlowKotlinCancellationException, FlowKtor_httpHttpStatusCodeCompanion, FlowKtor_utilsGMTDateCompanion, FlowKtor_utilsWeekDay, FlowKtor_utilsMonth, FlowKtor_httpHttpProtocolVersionCompanion, FlowKotlinAbstractCoroutineContextKey<B, E>, FlowKtor_ioMemory, FlowKtor_ioChunkBuffer, FlowKtor_ioBuffer, FlowKtor_ioByteReadPacket, FlowKtor_utilsStringValuesBuilderImpl, FlowKtor_httpURLBuilderCompanion, FlowKtor_httpURLProtocolCompanion, FlowKtor_httpHeaderValueParam, FlowKtor_httpHeaderValueWithParametersCompanion, FlowKtor_httpHeaderValueWithParameters, FlowKtor_httpContentTypeCompanion, FlowKtor_utilsWeekDayCompanion, FlowKtor_utilsMonthCompanion, FlowKtor_ioMemoryCompanion, FlowKtor_ioBufferCompanion, FlowKtor_ioChunkBufferCompanion, FlowKtor_ioInputCompanion, FlowKtor_ioInput, FlowKtor_ioByteReadPacketCompanion, FlowKotlinKTypeProjection, FlowKotlinx_coroutines_coreAtomicDesc, FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp, FlowKotlinKVariance, FlowKotlinKTypeProjectionCompanion, FlowKotlinx_coroutines_coreAtomicOp<__contravariant T>, FlowKotlinx_coroutines_coreOpDescriptor, FlowKotlinx_coroutines_coreLockFreeLinkedListNode, FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc, FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc<T>, FlowKotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc<T>;

@protocol FlowChainIdProvider, FlowKotlinx_serialization_coreEncoder, FlowKotlinx_serialization_coreSerialDescriptor, FlowKotlinx_serialization_coreSerializationStrategy, FlowKotlinx_serialization_coreDecoder, FlowKotlinx_serialization_coreDeserializationStrategy, FlowKotlinx_serialization_coreKSerializer, FlowKotlinComparable, FlowKotlinComparator, FlowSigner, FlowBignumBigNumber, FlowBignumBigNumberCreator, FlowBignumBitwiseCapable, FlowBignumByteArraySerializable, FlowKotlinIterator, FlowKotlinCoroutineContext, FlowKotlinx_coroutines_coreCoroutineScope, FlowKtor_ioCloseable, FlowKtor_client_coreHttpClientEngine, FlowKtor_client_coreHttpClientEngineCapability, FlowKtor_utilsAttributes, FlowKotlinx_serialization_coreCompositeEncoder, FlowKotlinAnnotation, FlowKotlinx_serialization_coreCompositeDecoder, FlowKotlinx_serialization_coreSerialFormat, FlowKotlinx_serialization_coreStringFormat, FlowBignumBigNumberUtil, FlowBignumByteArrayDeserializable, FlowKotlinClosedRange, FlowKotlinIterable, FlowKotlinCoroutineContextElement, FlowKotlinCoroutineContextKey, FlowKtor_client_coreHttpClientPlugin, FlowKotlinx_coroutines_coreDisposableHandle, FlowKotlinSuspendFunction2, FlowKotlinx_serialization_coreSerializersModuleCollector, FlowKotlinKClass, FlowKtor_httpHeaders, FlowKotlinx_coroutines_coreJob, FlowKotlinContinuation, FlowKotlinContinuationInterceptor, FlowKotlinx_coroutines_coreRunnable, FlowKotlinFunction, FlowKtor_httpHttpMessage, FlowKtor_ioByteReadChannel, FlowKtor_httpHttpMessageBuilder, FlowKtor_client_coreHttpRequest, FlowKotlinKDeclarationContainer, FlowKotlinKAnnotatedElement, FlowKotlinKClassifier, FlowKtor_httpParameters, FlowKotlinMapEntry, FlowKtor_utilsStringValues, FlowKotlinx_coroutines_coreChildHandle, FlowKotlinx_coroutines_coreChildJob, FlowKotlinSequence, FlowKotlinx_coroutines_coreSelectClause0, FlowKtor_ioReadSession, FlowKotlinSuspendFunction1, FlowKotlinAppendable, FlowKtor_utilsStringValuesBuilder, FlowKtor_httpParametersBuilder, FlowKotlinKType, FlowKotlinx_coroutines_coreParentJob, FlowKotlinx_coroutines_coreSelectInstance, FlowKotlinSuspendFunction0, FlowKtor_ioObjectPool;

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
@interface FlowBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface FlowBase (FlowBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface FlowMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface FlowMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorFlowKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface FlowNumber : NSNumber
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
@end;

__attribute__((swift_name("KotlinByte")))
@interface FlowByte : FlowNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface FlowUByte : FlowNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface FlowShort : FlowNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface FlowUShort : FlowNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface FlowInt : FlowNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface FlowUInt : FlowNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface FlowLong : FlowNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface FlowULong : FlowNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface FlowFloat : FlowNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface FlowDouble : FlowNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface FlowBoolean : FlowNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((swift_name("ChainIdProvider")))
@protocol FlowChainIdProvider
@required
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((swift_name("ChainId")))
@interface FlowChainId : FlowBase <FlowChainIdProvider>
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChainId.Canary")))
@interface FlowChainIdCanary : FlowChainId
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)canary __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowChainIdCanary *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChainId.Custom")))
@interface FlowChainIdCustom : FlowChainId
- (instancetype)initWithBaseUrl:(NSString *)baseUrl description:(NSString *)description __attribute__((swift_name("init(baseUrl:description:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowChainIdCustom *)doCopyBaseUrl:(NSString *)baseUrl description:(NSString *)description __attribute__((swift_name("doCopy(baseUrl:description:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChainId.Emulator")))
@interface FlowChainIdEmulator : FlowChainId
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)emulator __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowChainIdEmulator *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChainId.Mainnet")))
@interface FlowChainIdMainnet : FlowChainId
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)mainnet __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowChainIdMainnet *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChainId.Sandboxnet")))
@interface FlowChainIdSandboxnet : FlowChainId
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)sandboxnet __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowChainIdSandboxnet *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ChainId.Testnet")))
@interface FlowChainIdTestnet : FlowChainId
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)testnet __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowChainIdTestnet *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *baseUrl __attribute__((swift_name("baseUrl")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FlowApi")))
@interface FlowFlowApi : FlowBase
- (instancetype)initWithChainId:(id<FlowChainIdProvider>)chainId __attribute__((swift_name("init(chainId:)"))) __attribute__((objc_designated_initializer));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeScriptScript:(NSString *)script arguments:(NSArray<FlowCadenceValue *> * _Nullable)arguments blockId:(NSString * _Nullable)blockId blockHeight:(NSString * _Nullable)blockHeight completionHandler:(void (^)(FlowCadenceValue * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("executeScript(script:arguments:blockId:blockHeight:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountAddress:(NSString *)address blockHeight:(NSString * _Nullable)blockHeight sealed:(BOOL)sealed completionHandler:(void (^)(FlowAccount * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccount(address:blockHeight:sealed:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getBlockId:(NSString * _Nullable)id blockHeight:(NSString * _Nullable)blockHeight sealed:(BOOL)sealed completionHandler:(void (^)(FlowBlock * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getBlock(id:blockHeight:sealed:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getBlockHeaderId:(NSString * _Nullable)id blockHeight:(NSString * _Nullable)blockHeight sealed:(BOOL)sealed completionHandler:(void (^)(FlowBlockHeader * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getBlockHeader(id:blockHeight:sealed:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCollectionId:(NSString *)id completionHandler:(void (^)(FlowCollection * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getCollection(id:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getEventsType:(NSString *)type startHeight:(NSString * _Nullable)startHeight endHeight:(NSString * _Nullable)endHeight blockIds:(NSSet<NSString *> * _Nullable)blockIds completionHandler:(void (^)(FlowBlockEvents * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getEvents(type:startHeight:endHeight:blockIds:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getExecutionResultId:(NSString *)id completionHandler:(void (^)(FlowExecutionResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getExecutionResult(id:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getExecutionResultsBlockId:(NSSet<NSString *> *)blockId completionHandler:(void (^)(NSArray<FlowExecutionResult *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getExecutionResults(blockId:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getTransactionTransactionId:(NSString *)transactionId completionHandler:(void (^)(FlowTransaction * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getTransaction(transactionId:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getTransactionResultTransactionId:(NSString *)transactionId completionHandler:(void (^)(FlowTransactionResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getTransactionResult(transactionId:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)sendTransactionRequest:(FlowTransaction *)request completionHandler:(void (^)(FlowTransaction * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("sendTransaction(request:completionHandler:)")));
@property (readonly) id<FlowChainIdProvider> chainId __attribute__((swift_name("chainId")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface FlowKotlinThrowable : FlowBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (FlowKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end;

__attribute__((swift_name("KotlinException")))
@interface FlowKotlinException : FlowKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface FlowKotlinRuntimeException : FlowKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalArgumentException")))
@interface FlowKotlinIllegalArgumentException : FlowKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IllegalRLPException")))
@interface FlowIllegalRLPException : FlowKotlinIllegalArgumentException
- (instancetype)initWithMsg:(NSString *)msg __attribute__((swift_name("init(msg:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("RLPType")))
@interface FlowRLPType : FlowBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RLPElement")))
@interface FlowRLPElement : FlowRLPType
- (instancetype)initWithBytes:(FlowKotlinByteArray *)bytes __attribute__((swift_name("init(bytes:)"))) __attribute__((objc_designated_initializer));
- (FlowKotlinByteArray *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowRLPElement *)doCopyBytes:(FlowKotlinByteArray *)bytes __attribute__((swift_name("doCopy(bytes:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKotlinByteArray *bytes __attribute__((swift_name("bytes")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RLPList")))
@interface FlowRLPList : FlowRLPType
- (instancetype)initWithElement:(NSArray<FlowRLPType *> *)element __attribute__((swift_name("init(element:)"))) __attribute__((objc_designated_initializer));
- (NSArray<FlowRLPType *> *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowRLPList *)doCopyElement:(NSArray<FlowRLPType *> *)element __attribute__((swift_name("doCopy(element:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<FlowRLPType *> *element __attribute__((swift_name("element")));
@end;

__attribute__((swift_name("ApiBase")))
@interface FlowApiBase : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) FlowApiBaseCompanion *companion __attribute__((swift_name("companion")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ApiBase.Companion")))
@interface FlowApiBaseCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowApiBaseCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_client_coreHttpClient *client __attribute__((swift_name("client")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Base64ByteArray")))
@interface FlowBase64ByteArray : FlowBase
- (instancetype)initWithBytes:(FlowKotlinByteArray *)bytes __attribute__((swift_name("init(bytes:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBase64ByteArrayCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKotlinByteArray *bytes __attribute__((swift_name("bytes")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol FlowKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol FlowKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol FlowKotlinx_serialization_coreKSerializer <FlowKotlinx_serialization_coreSerializationStrategy, FlowKotlinx_serialization_coreDeserializationStrategy>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Base64ByteArray.Companion")))
@interface FlowBase64ByteArrayCompanion : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBase64ByteArrayCompanion *shared __attribute__((swift_name("shared")));
- (FlowBase64ByteArray *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowBase64ByteArray *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BigDecimalCadenceSerializer")))
@interface FlowBigDecimalCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)bigDecimalCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBigDecimalCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowBignumBigDecimal *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowBignumBigDecimal *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BigIntegerCadenceSerializer")))
@interface FlowBigIntegerCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)bigIntegerCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBigIntegerCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowBignumBigInteger *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowBignumBigInteger *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ByteCadenceSerializer")))
@interface FlowByteCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)byteCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowByteCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowByte *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowByte *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence")))
@interface FlowCadence : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) FlowCadenceCompanion *companion __attribute__((swift_name("companion")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.Capability")))
@interface FlowCadenceCapability : FlowBase
- (instancetype)initWithPath:(NSString *)path address:(NSString *)address borrowType:(FlowCadenceType *)borrowType __attribute__((swift_name("init(path:address:borrowType:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceCapabilityCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceType *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceCapability *)doCopyPath:(NSString *)path address:(NSString *)address borrowType:(FlowCadenceType *)borrowType __attribute__((swift_name("doCopy(path:address:borrowType:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) FlowCadenceType *borrowType __attribute__((swift_name("borrowType")));
@property (readonly) NSString *path __attribute__((swift_name("path")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.CapabilityCompanion")))
@interface FlowCadenceCapabilityCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceCapabilityCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.Companion")))
@interface FlowCadenceCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceCompanion *shared __attribute__((swift_name("shared")));
- (FlowCadenceValueAddressValue *)addressValue:(FlowKotlinByteArray *)value __attribute__((swift_name("address(value:)")));
- (FlowCadenceValueAddressValue *)addressValue_:(NSString *)value __attribute__((swift_name("address(value_:)")));
- (FlowCadenceValueArrayValue *)arrayValue:(NSArray<FlowCadenceValue *> *)value __attribute__((swift_name("array(value:)")));
- (FlowCadenceValueBooleanValue *)boolValue:(BOOL)value __attribute__((swift_name("bool(value:)")));
- (FlowCadenceValueCapabilityValue *)capabilityPath:(NSString *)path address:(NSString *)address borrowType:(FlowCadenceType *)borrowType __attribute__((swift_name("capability(path:address:borrowType:)")));
- (FlowCadenceValueCapabilityValue *)capabilityValue:(FlowCadenceCapability *)value __attribute__((swift_name("capability(value:)")));
- (FlowCadenceValueContractValue *)contractValueValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("contractValue(value:)")));
- (FlowCadenceValueDictionaryValue *)dictionaryValue:(NSArray<FlowCadenceDictionaryFieldEntry *> *)value __attribute__((swift_name("dictionary(value:)")));
- (FlowCadenceValueDictionaryValue *)dictionaryValue_:(NSDictionary<FlowCadenceValue *, FlowCadenceValue *> *)value __attribute__((swift_name("dictionary(value_:)")));
- (FlowCadenceValueContractValue *)enumValueValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("enumValue(value:)")));
- (FlowCadenceValueContractValue *)eventValueValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("eventValue(value:)")));
- (FlowCadenceValueFix64Value *)fix64Value:(double)value __attribute__((swift_name("fix64(value:)")));
- (FlowCadenceValueFix64Value *)fix64Value_:(id)value __attribute__((swift_name("fix64(value_:)")));
- (FlowCadenceValueFix64Value *)fix64Value__:(NSString *)value __attribute__((swift_name("fix64(value__:)")));
- (FlowCadenceValueIntValue *)intValue:(int32_t)value __attribute__((swift_name("int(value:)")));
- (FlowCadenceValueInt128Value *)int128Value:(FlowBignumBigInteger *)value __attribute__((swift_name("int128(value:)")));
- (FlowCadenceValueInt16Value *)int16Value:(int16_t)value __attribute__((swift_name("int16(value:)")));
- (FlowCadenceValueInt256Value *)int256Value:(FlowBignumBigInteger *)value __attribute__((swift_name("int256(value:)")));
- (FlowCadenceValueInt32Value *)int32Value:(int32_t)value __attribute__((swift_name("int32(value:)")));
- (FlowCadenceValueInt64Value *)int64Value:(int64_t)value __attribute__((swift_name("int64(value:)")));
- (FlowCadenceValueInt8Value *)int8Value:(int8_t)value __attribute__((swift_name("int8(value:)")));
- (FlowCadenceValueOptionalValue *)optionalValue:(FlowCadenceValue * _Nullable)value __attribute__((swift_name("optional(value:)")));
- (FlowCadenceValuePathValue *)pathValue:(FlowCadencePath *)value __attribute__((swift_name("path(value:)")));
- (FlowCadenceValuePathValue *)pathDomain:(FlowCadencePathDomain *)domain identifier:(NSString *)identifier __attribute__((swift_name("path(domain:identifier:)")));
- (FlowCadenceValueContractValue *)resourceValueValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("resourceValue(value:)")));
- (FlowCadenceValueStringValue *)stringValue:(NSString *)value __attribute__((swift_name("string(value:)")));
- (FlowCadenceValueStructValue *)structValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("struct(value:)")));
- (FlowCadenceValueTypeValue *)typeValue:(FlowCadenceKind *)value __attribute__((swift_name("type(value:)")));
- (FlowCadenceValueTypeValue *)typeValue_:(FlowCadenceTypeEntry *)value __attribute__((swift_name("type(value_:)")));
- (FlowCadenceValueUFix64Value *)ufix64Value:(double)value __attribute__((swift_name("ufix64(value:)")));
- (FlowCadenceValueUFix64Value *)ufix64Value_:(id)value __attribute__((swift_name("ufix64(value_:)")));
- (FlowCadenceValueUFix64Value *)ufix64Value__:(NSString *)value __attribute__((swift_name("ufix64(value__:)")));
- (FlowCadenceValueUIntValue *)uintValue:(uint32_t)value __attribute__((swift_name("uint(value:)")));
- (FlowCadenceValueUInt128Value *)uint128Value:(FlowBignumBigInteger *)value __attribute__((swift_name("uint128(value:)")));
- (FlowCadenceValueUInt16Value *)uint16Value:(uint16_t)value __attribute__((swift_name("uint16(value:)")));
- (FlowCadenceValueUInt256Value *)uint256Value:(FlowBignumBigInteger *)value __attribute__((swift_name("uint256(value:)")));
- (FlowCadenceValueUInt32Value *)uint32Value:(uint32_t)value __attribute__((swift_name("uint32(value:)")));
- (FlowCadenceValueUInt64Value *)uint64Value:(uint64_t)value __attribute__((swift_name("uint64(value:)")));
- (FlowCadenceValueUInt8Value *)uint8Value:(uint8_t)value __attribute__((swift_name("uint8(value:)")));
- (FlowCadenceValueVoidValue *)void __attribute__((swift_name("void()")));
- (FlowCadenceValueWord16Value *)word16Value:(uint16_t)value __attribute__((swift_name("word16(value:)")));
- (FlowCadenceValueWord32Value *)word32Value:(uint32_t)value __attribute__((swift_name("word32(value:)")));
- (FlowCadenceValueWord64Value *)word64Value:(uint64_t)value __attribute__((swift_name("word64(value:)")));
- (FlowCadenceValueWord8Value *)word8Value:(uint8_t)value __attribute__((swift_name("word8(value:)")));
@end;

__attribute__((swift_name("Cadence.CompositeAttribute")))
@interface FlowCadenceCompositeAttribute : FlowBase
- (instancetype)initWithName:(NSString *)name value:(FlowCadenceValue *)value __attribute__((swift_name("init(name:value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceCompositeAttributeCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) FlowCadenceValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.CompositeAttributeCompanion")))
@interface FlowCadenceCompositeAttributeCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceCompositeAttributeCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Cadence.CompositeValue")))
@interface FlowCadenceCompositeValue : FlowBase
- (instancetype)initWithId:(NSString *)id fields:(NSArray<FlowCadenceCompositeAttribute *> *)fields __attribute__((swift_name("init(id:fields:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceCompositeValueCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property (readonly) NSArray<FlowCadenceCompositeAttribute *> *fields __attribute__((swift_name("fields")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.CompositeValueCompanion")))
@interface FlowCadenceCompositeValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceCompositeValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.DictionaryFieldEntry")))
@interface FlowCadenceDictionaryFieldEntry : FlowBase
- (instancetype)initWithPair:(FlowKotlinPair<FlowCadenceValue *, FlowCadenceValue *> *)pair __attribute__((swift_name("init(pair:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithKey:(FlowCadenceValue *)key value:(FlowCadenceValue *)value __attribute__((swift_name("init(key:value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceDictionaryFieldEntryCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property (readonly) FlowCadenceValue *key __attribute__((swift_name("key")));
@property (readonly) FlowCadenceValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.DictionaryFieldEntryCompanion")))
@interface FlowCadenceDictionaryFieldEntryCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceDictionaryFieldEntryCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.Kind")))
@interface FlowCadenceKind : FlowBase
- (instancetype)initWithKind:(FlowCadenceType *)kind typeID:(NSString * _Nullable)typeID type:(NSString * _Nullable)type __attribute__((swift_name("init(kind:typeID:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceKindCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceType *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceKind *)doCopyKind:(FlowCadenceType *)kind typeID:(NSString * _Nullable)typeID type:(NSString * _Nullable)type __attribute__((swift_name("doCopy(kind:typeID:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceType *kind __attribute__((swift_name("kind")));
@property (readonly) NSString * _Nullable type __attribute__((swift_name("type")));
@property (readonly) NSString * _Nullable typeID __attribute__((swift_name("typeID")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.KindCompanion")))
@interface FlowCadenceKindCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceKindCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.Path")))
@interface FlowCadencePath : FlowBase
- (instancetype)initWithDomain:(FlowCadencePathDomain *)domain identifier:(NSString *)identifier __attribute__((swift_name("init(domain:identifier:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadencePathCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadencePathDomain *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadencePath *)doCopyDomain:(FlowCadencePathDomain *)domain identifier:(NSString *)identifier __attribute__((swift_name("doCopy(domain:identifier:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadencePathDomain *domain __attribute__((swift_name("domain")));
@property (readonly) NSString *identifier __attribute__((swift_name("identifier")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.PathCompanion")))
@interface FlowCadencePathCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadencePathCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol FlowKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface FlowKotlinEnum<E> : FlowBase <FlowKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.PathDomain")))
@interface FlowCadencePathDomain : FlowKotlinEnum<FlowCadencePathDomain *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowCadencePathDomainCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowCadencePathDomain *storage __attribute__((swift_name("storage")));
@property (class, readonly) FlowCadencePathDomain *private_ __attribute__((swift_name("private_")));
@property (class, readonly) FlowCadencePathDomain *public_ __attribute__((swift_name("public_")));
+ (FlowKotlinArray<FlowCadencePathDomain *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.PathDomainCompanion")))
@interface FlowCadencePathDomainCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadencePathDomainCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.Type_")))
@interface FlowCadenceType : FlowKotlinEnum<FlowCadenceType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowCadenceTypeCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowCadenceType *void_ __attribute__((swift_name("void_")));
@property (class, readonly) FlowCadenceType *optional __attribute__((swift_name("optional")));
@property (class, readonly) FlowCadenceType *boolean __attribute__((swift_name("boolean")));
@property (class, readonly) FlowCadenceType *string __attribute__((swift_name("string")));
@property (class, readonly) FlowCadenceType *int_ __attribute__((swift_name("int_")));
@property (class, readonly) FlowCadenceType *uint __attribute__((swift_name("uint")));
@property (class, readonly) FlowCadenceType *int8 __attribute__((swift_name("int8")));
@property (class, readonly) FlowCadenceType *uint8 __attribute__((swift_name("uint8")));
@property (class, readonly) FlowCadenceType *int16 __attribute__((swift_name("int16")));
@property (class, readonly) FlowCadenceType *uint16 __attribute__((swift_name("uint16")));
@property (class, readonly) FlowCadenceType *int32 __attribute__((swift_name("int32")));
@property (class, readonly) FlowCadenceType *uint32 __attribute__((swift_name("uint32")));
@property (class, readonly) FlowCadenceType *int64 __attribute__((swift_name("int64")));
@property (class, readonly) FlowCadenceType *uint64 __attribute__((swift_name("uint64")));
@property (class, readonly) FlowCadenceType *int128 __attribute__((swift_name("int128")));
@property (class, readonly) FlowCadenceType *uint128 __attribute__((swift_name("uint128")));
@property (class, readonly) FlowCadenceType *int256 __attribute__((swift_name("int256")));
@property (class, readonly) FlowCadenceType *uint256 __attribute__((swift_name("uint256")));
@property (class, readonly) FlowCadenceType *word8 __attribute__((swift_name("word8")));
@property (class, readonly) FlowCadenceType *word16 __attribute__((swift_name("word16")));
@property (class, readonly) FlowCadenceType *word32 __attribute__((swift_name("word32")));
@property (class, readonly) FlowCadenceType *word64 __attribute__((swift_name("word64")));
@property (class, readonly) FlowCadenceType *fix64 __attribute__((swift_name("fix64")));
@property (class, readonly) FlowCadenceType *ufix64 __attribute__((swift_name("ufix64")));
@property (class, readonly) FlowCadenceType *array __attribute__((swift_name("array")));
@property (class, readonly) FlowCadenceType *dictionary __attribute__((swift_name("dictionary")));
@property (class, readonly) FlowCadenceType *address __attribute__((swift_name("address")));
@property (class, readonly) FlowCadenceType *path __attribute__((swift_name("path")));
@property (class, readonly) FlowCadenceType *capability __attribute__((swift_name("capability")));
@property (class, readonly) FlowCadenceType *struct_ __attribute__((swift_name("struct_")));
@property (class, readonly) FlowCadenceType *resource __attribute__((swift_name("resource")));
@property (class, readonly) FlowCadenceType *event __attribute__((swift_name("event")));
@property (class, readonly) FlowCadenceType *contract __attribute__((swift_name("contract")));
@property (class, readonly) FlowCadenceType *enum_ __attribute__((swift_name("enum_")));
@property (class, readonly) FlowCadenceType *type __attribute__((swift_name("type")));
+ (FlowKotlinArray<FlowCadenceType *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.Type_Companion")))
@interface FlowCadenceTypeCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceTypeCompanion *shared __attribute__((swift_name("shared")));
- (FlowCadenceType *)findByKeyValue:(NSString *)value default:(FlowCadenceType *)default_ __attribute__((swift_name("findByKey(value:default:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.TypeEntry")))
@interface FlowCadenceTypeEntry : FlowBase
- (instancetype)initWithStaticType:(FlowCadenceKind *)staticType __attribute__((swift_name("init(staticType:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceTypeEntryCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceKind *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceTypeEntry *)doCopyStaticType:(FlowCadenceKind *)staticType __attribute__((swift_name("doCopy(staticType:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceKind *staticType __attribute__((swift_name("staticType")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.TypeEntryCompanion")))
@interface FlowCadenceTypeEntryCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceTypeEntryCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Cadence.Value")))
@interface FlowCadenceValue : FlowBase
@property (class, readonly, getter=companion) FlowCadenceValueCompanion *companion __attribute__((swift_name("companion")));

/**
 @note This method converts instances of Exception to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (id _Nullable)decodeAndReturnError:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("decode()"))) __attribute__((swift_error(nonnull_error)));
- (id _Nullable)decodeToAny __attribute__((swift_name("decodeToAny()")));
- (NSString *)encode __attribute__((swift_name("encode()")));
- (NSString *)encodeBase64 __attribute__((swift_name("encodeBase64()")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueAddressValue")))
@interface FlowCadenceValueAddressValue : FlowCadenceValue
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueAddressValueCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueAddressValue *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueAddressValueCompanion")))
@interface FlowCadenceValueAddressValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueAddressValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueArrayValue")))
@interface FlowCadenceValueArrayValue : FlowCadenceValue
- (instancetype)initWithValue:(NSArray<FlowCadenceValue *> *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueArrayValueCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<FlowCadenceValue *> *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueArrayValue *)doCopyValue:(NSArray<FlowCadenceValue *> *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<FlowCadenceValue *> *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueArrayValueCompanion")))
@interface FlowCadenceValueArrayValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueArrayValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueBooleanValue")))
@interface FlowCadenceValueBooleanValue : FlowCadenceValue
- (instancetype)initWithValue:(BOOL)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueBooleanValueCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueBooleanValue *)doCopyValue:(BOOL)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBoolean *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueBooleanValueCompanion")))
@interface FlowCadenceValueBooleanValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueBooleanValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Cadence.ValueCapabilityValue")))
@interface FlowCadenceValueCapabilityValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceCapability *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueCapabilityValueCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) FlowCadenceCapability *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueCapabilityValueCompanion")))
@interface FlowCadenceValueCapabilityValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueCapabilityValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueCompanion")))
@interface FlowCadenceValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueCompanion *shared __attribute__((swift_name("shared")));
- (FlowCadenceValue *)decodeFromBase64Base64String:(NSString *)base64String __attribute__((swift_name("decodeFromBase64(base64String:)")));
- (FlowCadenceValue *)decodeFromJsonJsonString:(NSString *)jsonString __attribute__((swift_name("decodeFromJson(jsonString:)")));
- (FlowCadenceValue *)decodeFromJsonElementJsonElement:(FlowKotlinx_serialization_jsonJsonElement *)jsonElement __attribute__((swift_name("decodeFromJsonElement(jsonElement:)")));
- (NSString *)encodeToJsonStringValue:(FlowCadenceValue *)Value __attribute__((swift_name("encodeToJsonString(Value:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(FlowKotlinArray<id<FlowKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@property (readonly) FlowKotlinx_serialization_jsonJson *jsonSerializer __attribute__((swift_name("jsonSerializer")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueContractValue")))
@interface FlowCadenceValueContractValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueContractValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceCompositeValue *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueContractValue *)doCopyValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceCompositeValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueContractValueCompanion")))
@interface FlowCadenceValueContractValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueContractValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueDictionaryValue")))
@interface FlowCadenceValueDictionaryValue : FlowCadenceValue
- (instancetype)initWithValue:(NSArray<FlowCadenceDictionaryFieldEntry *> *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueDictionaryValueCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<FlowCadenceDictionaryFieldEntry *> *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueDictionaryValue *)doCopyValue:(NSArray<FlowCadenceDictionaryFieldEntry *> *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<FlowCadenceDictionaryFieldEntry *> *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueDictionaryValueCompanion")))
@interface FlowCadenceValueDictionaryValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueDictionaryValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueEnumValue")))
@interface FlowCadenceValueEnumValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueEnumValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceCompositeValue *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueEnumValue *)doCopyValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceCompositeValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueEnumValueCompanion")))
@interface FlowCadenceValueEnumValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueEnumValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueEventValue")))
@interface FlowCadenceValueEventValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueEventValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceCompositeValue *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueEventValue *)doCopyValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceCompositeValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueEventValueCompanion")))
@interface FlowCadenceValueEventValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueEventValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueFix64Value")))
@interface FlowCadenceValueFix64Value : FlowCadenceValue
- (instancetype)initWithValue:(double)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueFix64ValueCompanion *companion __attribute__((swift_name("companion")));
- (double)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueFix64Value *)doCopyValue:(double)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowDouble *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueFix64ValueCompanion")))
@interface FlowCadenceValueFix64ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueFix64ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt128Value")))
@interface FlowCadenceValueInt128Value : FlowCadenceValue
- (instancetype)initWithValue:(FlowBignumBigInteger *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueInt128ValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueInt128Value *)doCopyValue:(FlowBignumBigInteger *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumBigInteger *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt128ValueCompanion")))
@interface FlowCadenceValueInt128ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueInt128ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt16Value")))
@interface FlowCadenceValueInt16Value : FlowCadenceValue
- (instancetype)initWithValue:(int16_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueInt16ValueCompanion *companion __attribute__((swift_name("companion")));
- (int16_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueInt16Value *)doCopyValue:(int16_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowShort *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt16ValueCompanion")))
@interface FlowCadenceValueInt16ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueInt16ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt256Value")))
@interface FlowCadenceValueInt256Value : FlowCadenceValue
- (instancetype)initWithValue:(FlowBignumBigInteger *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueInt256ValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueInt256Value *)doCopyValue:(FlowBignumBigInteger *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumBigInteger *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt256ValueCompanion")))
@interface FlowCadenceValueInt256ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueInt256ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt32Value")))
@interface FlowCadenceValueInt32Value : FlowCadenceValue
- (instancetype)initWithValue:(int32_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueInt32ValueCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueInt32Value *)doCopyValue:(int32_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowInt *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt32ValueCompanion")))
@interface FlowCadenceValueInt32ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueInt32ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt64Value")))
@interface FlowCadenceValueInt64Value : FlowCadenceValue
- (instancetype)initWithValue:(int64_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueInt64ValueCompanion *companion __attribute__((swift_name("companion")));
- (int64_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueInt64Value *)doCopyValue:(int64_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowLong *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt64ValueCompanion")))
@interface FlowCadenceValueInt64ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueInt64ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt8Value")))
@interface FlowCadenceValueInt8Value : FlowCadenceValue
- (instancetype)initWithValue:(int8_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueInt8ValueCompanion *companion __attribute__((swift_name("companion")));
- (int8_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueInt8Value *)doCopyValue:(int8_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowByte *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueInt8ValueCompanion")))
@interface FlowCadenceValueInt8ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueInt8ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueIntValue")))
@interface FlowCadenceValueIntValue : FlowCadenceValue
- (instancetype)initWithValue:(int32_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueIntValueCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueIntValue *)doCopyValue:(int32_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowInt *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueIntValueCompanion")))
@interface FlowCadenceValueIntValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueIntValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueOptionalValue")))
@interface FlowCadenceValueOptionalValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceValue * _Nullable)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueOptionalValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceValue * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueOptionalValue *)doCopyValue:(FlowCadenceValue * _Nullable)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceValue * _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueOptionalValueCompanion")))
@interface FlowCadenceValueOptionalValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueOptionalValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Cadence.ValuePathValue")))
@interface FlowCadenceValuePathValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadencePath *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValuePathValueCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) FlowCadencePath *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValuePathValueCompanion")))
@interface FlowCadenceValuePathValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValuePathValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueResourceValue")))
@interface FlowCadenceValueResourceValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueResourceValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowCadenceCompositeValue *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueResourceValue *)doCopyValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCadenceCompositeValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueResourceValueCompanion")))
@interface FlowCadenceValueResourceValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueResourceValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueStringValue")))
@interface FlowCadenceValueStringValue : FlowCadenceValue
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueStringValueCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueStringValue *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueStringValueCompanion")))
@interface FlowCadenceValueStringValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueStringValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Cadence.ValueStructValue")))
@interface FlowCadenceValueStructValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceCompositeValue *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueStructValueCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) FlowCadenceCompositeValue *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueStructValueCompanion")))
@interface FlowCadenceValueStructValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueStructValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Cadence.ValueTypeValue")))
@interface FlowCadenceValueTypeValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowCadenceTypeEntry *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueTypeValueCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) FlowCadenceTypeEntry *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueTypeValueCompanion")))
@interface FlowCadenceValueTypeValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueTypeValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUFix64Value")))
@interface FlowCadenceValueUFix64Value : FlowCadenceValue
- (instancetype)initWithValue:(double)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUFix64ValueCompanion *companion __attribute__((swift_name("companion")));
- (double)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUFix64Value *)doCopyValue:(double)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowDouble *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUFix64ValueCompanion")))
@interface FlowCadenceValueUFix64ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUFix64ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt128Value")))
@interface FlowCadenceValueUInt128Value : FlowCadenceValue
- (instancetype)initWithValue:(FlowBignumBigInteger *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUInt128ValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUInt128Value *)doCopyValue:(FlowBignumBigInteger *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumBigInteger *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt128ValueCompanion")))
@interface FlowCadenceValueUInt128ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUInt128ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt16Value")))
@interface FlowCadenceValueUInt16Value : FlowCadenceValue
- (instancetype)initWithValue:(uint16_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUInt16ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint16_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUInt16Value *)doCopyValue:(uint16_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUShort *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt16ValueCompanion")))
@interface FlowCadenceValueUInt16ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUInt16ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt256Value")))
@interface FlowCadenceValueUInt256Value : FlowCadenceValue
- (instancetype)initWithValue:(FlowBignumBigInteger *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUInt256ValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUInt256Value *)doCopyValue:(FlowBignumBigInteger *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumBigInteger *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt256ValueCompanion")))
@interface FlowCadenceValueUInt256ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUInt256ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt32Value")))
@interface FlowCadenceValueUInt32Value : FlowCadenceValue
- (instancetype)initWithValue:(uint32_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUInt32ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUInt32Value *)doCopyValue:(uint32_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUInt *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt32ValueCompanion")))
@interface FlowCadenceValueUInt32ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUInt32ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt64Value")))
@interface FlowCadenceValueUInt64Value : FlowCadenceValue
- (instancetype)initWithValue:(uint64_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUInt64ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint64_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUInt64Value *)doCopyValue:(uint64_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowULong *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt64ValueCompanion")))
@interface FlowCadenceValueUInt64ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUInt64ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt8Value")))
@interface FlowCadenceValueUInt8Value : FlowCadenceValue
- (instancetype)initWithValue:(uint8_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUInt8ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint8_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUInt8Value *)doCopyValue:(uint8_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUByte *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUInt8ValueCompanion")))
@interface FlowCadenceValueUInt8ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUInt8ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUIntValue")))
@interface FlowCadenceValueUIntValue : FlowCadenceValue
- (instancetype)initWithValue:(uint32_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueUIntValueCompanion *companion __attribute__((swift_name("companion")));
- (uint32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueUIntValue *)doCopyValue:(uint32_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUInt *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueUIntValueCompanion")))
@interface FlowCadenceValueUIntValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueUIntValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueVoidValue")))
@interface FlowCadenceValueVoidValue : FlowCadenceValue
- (instancetype)initWithValue:(FlowKotlinUnit * _Nullable)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueVoidValueCompanion *companion __attribute__((swift_name("companion")));
- (FlowKotlinUnit * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueVoidValue *)doCopyValue:(FlowKotlinUnit * _Nullable)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKotlinUnit * _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueVoidValueCompanion")))
@interface FlowCadenceValueVoidValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueVoidValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord16Value")))
@interface FlowCadenceValueWord16Value : FlowCadenceValue
- (instancetype)initWithValue:(uint16_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueWord16ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint16_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueWord16Value *)doCopyValue:(uint16_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUShort *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord16ValueCompanion")))
@interface FlowCadenceValueWord16ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueWord16ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord32Value")))
@interface FlowCadenceValueWord32Value : FlowCadenceValue
- (instancetype)initWithValue:(uint32_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueWord32ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueWord32Value *)doCopyValue:(uint32_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUInt *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord32ValueCompanion")))
@interface FlowCadenceValueWord32ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueWord32ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord64Value")))
@interface FlowCadenceValueWord64Value : FlowCadenceValue
- (instancetype)initWithValue:(uint64_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueWord64ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint64_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueWord64Value *)doCopyValue:(uint64_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowULong *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord64ValueCompanion")))
@interface FlowCadenceValueWord64ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueWord64ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord8Value")))
@interface FlowCadenceValueWord8Value : FlowCadenceValue
- (instancetype)initWithValue:(uint8_t)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCadenceValueWord8ValueCompanion *companion __attribute__((swift_name("companion")));
- (uint8_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValueWord8Value *)doCopyValue:(uint8_t)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowUByte *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Cadence.ValueWord8ValueCompanion")))
@interface FlowCadenceValueWord8ValueCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceValueWord8ValueCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CadenceTypeSerializer")))
@interface FlowCadenceTypeSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)cadenceTypeSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceTypeSerializer *shared __attribute__((swift_name("shared")));
- (FlowCadenceType *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowCadenceType *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DoubleCadenceSerializer")))
@interface FlowDoubleCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)doubleCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowDoubleCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowDouble *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowDouble *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FixedPointFormatter")))
@interface FlowFixedPointFormatter : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)fixedPointFormatter __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowFixedPointFormatter *shared __attribute__((swift_name("shared")));
- (NSString * _Nullable)formatNum:(NSString *)num precision:(uint64_t)precision __attribute__((swift_name("format(num:precision:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IntCadenceSerializer")))
@interface FlowIntCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)intCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowIntCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowInt *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowInt *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LongCadenceSerializer")))
@interface FlowLongCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)longCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowLongCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowLong *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowLong *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ShortCadenceSerializer")))
@interface FlowShortCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)shortCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowShortCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowShort *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowShort *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UByteCadenceSerializer")))
@interface FlowUByteCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)uByteCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowUByteCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowUByte *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowUByte *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UIntCadenceSerializer")))
@interface FlowUIntCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)uIntCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowUIntCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowUInt *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowUInt *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ULongCadenceSerializer")))
@interface FlowULongCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)uLongCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowULongCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowULong *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowULong *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UShortCadenceSerializer")))
@interface FlowUShortCadenceSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)uShortCadenceSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowUShortCadenceSerializer *shared __attribute__((swift_name("shared")));
- (FlowUShort *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowUShort *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Account")))
@interface FlowAccount : FlowBase
- (instancetype)initWithAddress:(NSString *)address balance:(NSString *)balance expandable:(FlowAccountExpandable *)expandable keys:(NSSet<FlowAccountPublicKey *> * _Nullable)keys contracts:(NSDictionary<NSString *, FlowBase64ByteArray *> * _Nullable)contracts links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(address:balance:expandable:keys:contracts:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowAccountCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowAccountExpandable *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSSet<FlowAccountPublicKey *> * _Nullable)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSDictionary<NSString *, FlowBase64ByteArray *> * _Nullable)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowAccount *)doCopyAddress:(NSString *)address balance:(NSString *)balance expandable:(FlowAccountExpandable *)expandable keys:(NSSet<FlowAccountPublicKey *> * _Nullable)keys contracts:(NSDictionary<NSString *, FlowBase64ByteArray *> * _Nullable)contracts links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(address:balance:expandable:keys:contracts:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) NSString *balance __attribute__((swift_name("balance")));
@property (readonly) NSDictionary<NSString *, FlowBase64ByteArray *> * _Nullable contracts __attribute__((swift_name("contracts")));
@property (readonly) FlowAccountExpandable *expandable __attribute__((swift_name("expandable")));
@property (readonly) NSSet<FlowAccountPublicKey *> * _Nullable keys __attribute__((swift_name("keys")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Account.Companion")))
@interface FlowAccountCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowAccountCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountExpandable")))
@interface FlowAccountExpandable : FlowBase
- (instancetype)initWithPropertyKeys:(NSString * _Nullable)propertyKeys contracts:(NSString * _Nullable)contracts __attribute__((swift_name("init(propertyKeys:contracts:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowAccountExpandableCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowAccountExpandable *)doCopyPropertyKeys:(NSString * _Nullable)propertyKeys contracts:(NSString * _Nullable)contracts __attribute__((swift_name("doCopy(propertyKeys:contracts:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable contracts __attribute__((swift_name("contracts")));
@property (readonly) NSString * _Nullable propertyKeys __attribute__((swift_name("propertyKeys")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountExpandable.Companion")))
@interface FlowAccountExpandableCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowAccountExpandableCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountPublicKey")))
@interface FlowAccountPublicKey : FlowBase
- (instancetype)initWithIndex:(NSString *)index publicKey:(NSString *)publicKey signingAlgorithm:(FlowSigningAlgorithm *)signingAlgorithm hashingAlgorithm:(FlowHashingAlgorithm *)hashingAlgorithm sequenceNumber:(NSString *)sequenceNumber weight:(NSString *)weight revoked:(BOOL)revoked __attribute__((swift_name("init(index:publicKey:signingAlgorithm:hashingAlgorithm:sequenceNumber:weight:revoked:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowAccountPublicKeyCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowSigningAlgorithm *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowHashingAlgorithm *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (BOOL)component7 __attribute__((swift_name("component7()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowAccountPublicKey *)doCopyIndex:(NSString *)index publicKey:(NSString *)publicKey signingAlgorithm:(FlowSigningAlgorithm *)signingAlgorithm hashingAlgorithm:(FlowHashingAlgorithm *)hashingAlgorithm sequenceNumber:(NSString *)sequenceNumber weight:(NSString *)weight revoked:(BOOL)revoked __attribute__((swift_name("doCopy(index:publicKey:signingAlgorithm:hashingAlgorithm:sequenceNumber:weight:revoked:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowHashingAlgorithm *hashingAlgorithm __attribute__((swift_name("hashingAlgorithm")));
@property (readonly) NSString *index __attribute__((swift_name("index")));
@property (readonly) NSString *publicKey __attribute__((swift_name("publicKey")));
@property (readonly) BOOL revoked __attribute__((swift_name("revoked")));
@property (readonly) NSString *sequenceNumber __attribute__((swift_name("sequenceNumber")));
@property (readonly) FlowSigningAlgorithm *signingAlgorithm __attribute__((swift_name("signingAlgorithm")));
@property (readonly) NSString *weight __attribute__((swift_name("weight")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AccountPublicKey.Companion")))
@interface FlowAccountPublicKeyCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowAccountPublicKeyCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AggregatedSignature")))
@interface FlowAggregatedSignature : FlowBase
- (instancetype)initWithVerifierSignatures:(NSArray<FlowBase64ByteArray *> *)verifierSignatures signerIds:(NSArray<NSString *> *)signerIds __attribute__((swift_name("init(verifierSignatures:signerIds:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowAggregatedSignatureCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<FlowBase64ByteArray *> *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<NSString *> *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowAggregatedSignature *)doCopyVerifierSignatures:(NSArray<FlowBase64ByteArray *> *)verifierSignatures signerIds:(NSArray<NSString *> *)signerIds __attribute__((swift_name("doCopy(verifierSignatures:signerIds:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<NSString *> *signerIds __attribute__((swift_name("signerIds")));
@property (readonly) NSArray<FlowBase64ByteArray *> *verifierSignatures __attribute__((swift_name("verifierSignatures")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AggregatedSignature.Companion")))
@interface FlowAggregatedSignatureCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowAggregatedSignatureCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Base64HexSerializer")))
@interface FlowBase64HexSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)base64HexSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBase64HexSerializer *shared __attribute__((swift_name("shared")));
- (NSString *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(NSString *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Base64UFT8Serializer")))
@interface FlowBase64UFT8Serializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)base64UFT8Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBase64UFT8Serializer *shared __attribute__((swift_name("shared")));
- (NSString *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(NSString *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Block")))
@interface FlowBlock : FlowBase
- (instancetype)initWithHeader:(FlowBlockHeader *)header expandable:(FlowBlockExpandable *)expandable payload:(FlowBlockPayload * _Nullable)payload executionResult:(FlowExecutionResult * _Nullable)executionResult links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(header:expandable:payload:executionResult:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBlockCompanion *companion __attribute__((swift_name("companion")));
- (FlowBlockHeader *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockExpandable *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockPayload * _Nullable)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowExecutionResult * _Nullable)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlock *)doCopyHeader:(FlowBlockHeader *)header expandable:(FlowBlockExpandable *)expandable payload:(FlowBlockPayload * _Nullable)payload executionResult:(FlowExecutionResult * _Nullable)executionResult links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(header:expandable:payload:executionResult:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowExecutionResult * _Nullable executionResult __attribute__((swift_name("executionResult")));
@property (readonly) FlowBlockExpandable *expandable __attribute__((swift_name("expandable")));
@property (readonly) FlowBlockHeader *header __attribute__((swift_name("header")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@property (readonly) FlowBlockPayload * _Nullable payload __attribute__((swift_name("payload")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Block.Companion")))
@interface FlowBlockCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockEvents")))
@interface FlowBlockEvents : FlowBase
- (instancetype)initWithBlockId:(NSString * _Nullable)blockId blockHeight:(NSString * _Nullable)blockHeight blockTimestamp:(NSString * _Nullable)blockTimestamp events:(NSArray<FlowEvent *> * _Nullable)events links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(blockId:blockHeight:blockTimestamp:events:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBlockEventsCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowEvent *> * _Nullable)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockEvents *)doCopyBlockId:(NSString * _Nullable)blockId blockHeight:(NSString * _Nullable)blockHeight blockTimestamp:(NSString * _Nullable)blockTimestamp events:(NSArray<FlowEvent *> * _Nullable)events links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(blockId:blockHeight:blockTimestamp:events:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable blockHeight __attribute__((swift_name("blockHeight")));
@property (readonly) NSString * _Nullable blockId __attribute__((swift_name("blockId")));
@property (readonly) NSString * _Nullable blockTimestamp __attribute__((swift_name("blockTimestamp")));
@property (readonly) NSArray<FlowEvent *> * _Nullable events __attribute__((swift_name("events")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockEvents.Companion")))
@interface FlowBlockEventsCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockEventsCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockExpandable")))
@interface FlowBlockExpandable : FlowBase
- (instancetype)initWithPayload:(NSString * _Nullable)payload executionResult:(NSString * _Nullable)executionResult __attribute__((swift_name("init(payload:executionResult:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBlockExpandableCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockExpandable *)doCopyPayload:(NSString * _Nullable)payload executionResult:(NSString * _Nullable)executionResult __attribute__((swift_name("doCopy(payload:executionResult:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable executionResult __attribute__((swift_name("executionResult")));
@property (readonly) NSString * _Nullable payload __attribute__((swift_name("payload")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockExpandable.Companion")))
@interface FlowBlockExpandableCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockExpandableCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockHeader")))
@interface FlowBlockHeader : FlowBase
- (instancetype)initWithId:(NSString *)id parentId:(NSString *)parentId height:(NSString *)height timestamp:(NSString *)timestamp parentVoterSignature:(FlowBase64ByteArray *)parentVoterSignature __attribute__((swift_name("init(id:parentId:height:timestamp:parentVoterSignature:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBlockHeaderCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBase64ByteArray *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockHeader *)doCopyId:(NSString *)id parentId:(NSString *)parentId height:(NSString *)height timestamp:(NSString *)timestamp parentVoterSignature:(FlowBase64ByteArray *)parentVoterSignature __attribute__((swift_name("doCopy(id:parentId:height:timestamp:parentVoterSignature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *height __attribute__((swift_name("height")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) NSString *parentId __attribute__((swift_name("parentId")));
@property (readonly) FlowBase64ByteArray *parentVoterSignature __attribute__((swift_name("parentVoterSignature")));
@property (readonly) NSString *timestamp __attribute__((swift_name("timestamp")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockHeader.Companion")))
@interface FlowBlockHeaderCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockHeaderCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockHeightOneOf")))
@interface FlowBlockHeightOneOf : FlowKotlinEnum<FlowBlockHeightOneOf *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowBlockHeightOneOfCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowBlockHeightOneOf *final __attribute__((swift_name("final")));
@property (class, readonly) FlowBlockHeightOneOf *sealed __attribute__((swift_name("sealed")));
+ (FlowKotlinArray<FlowBlockHeightOneOf *> *)values __attribute__((swift_name("values()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockHeightOneOf.Companion")))
@interface FlowBlockHeightOneOfCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockHeightOneOfCompanion *shared __attribute__((swift_name("shared")));
- (FlowBlockHeightOneOf * _Nullable)decodeData:(id _Nullable)data __attribute__((swift_name("decode(data:)")));
- (NSString * _Nullable)encodeData:(id _Nullable)data __attribute__((swift_name("encode(data:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockPayload")))
@interface FlowBlockPayload : FlowBase
- (instancetype)initWithCollectionGuarantees:(NSArray<FlowCollectionGuarantee *> *)collectionGuarantees blockSeals:(NSArray<FlowBlockSeal *> *)blockSeals __attribute__((swift_name("init(collectionGuarantees:blockSeals:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBlockPayloadCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<FlowCollectionGuarantee *> *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowBlockSeal *> *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockPayload *)doCopyCollectionGuarantees:(NSArray<FlowCollectionGuarantee *> *)collectionGuarantees blockSeals:(NSArray<FlowBlockSeal *> *)blockSeals __attribute__((swift_name("doCopy(collectionGuarantees:blockSeals:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<FlowBlockSeal *> *blockSeals __attribute__((swift_name("blockSeals")));
@property (readonly) NSArray<FlowCollectionGuarantee *> *collectionGuarantees __attribute__((swift_name("collectionGuarantees")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockPayload.Companion")))
@interface FlowBlockPayloadCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockPayloadCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockSeal")))
@interface FlowBlockSeal : FlowBase
- (instancetype)initWithBlockId:(NSString *)blockId resultId:(NSString *)resultId finalState:(NSString *)finalState aggregatedApprovalSignatures:(NSArray<FlowAggregatedSignature *> *)aggregatedApprovalSignatures __attribute__((swift_name("init(blockId:resultId:finalState:aggregatedApprovalSignatures:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBlockSealCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowAggregatedSignature *> *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBlockSeal *)doCopyBlockId:(NSString *)blockId resultId:(NSString *)resultId finalState:(NSString *)finalState aggregatedApprovalSignatures:(NSArray<FlowAggregatedSignature *> *)aggregatedApprovalSignatures __attribute__((swift_name("doCopy(blockId:resultId:finalState:aggregatedApprovalSignatures:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<FlowAggregatedSignature *> *aggregatedApprovalSignatures __attribute__((swift_name("aggregatedApprovalSignatures")));
@property (readonly) NSString *blockId __attribute__((swift_name("blockId")));
@property (readonly) NSString *finalState __attribute__((swift_name("finalState")));
@property (readonly) NSString *resultId __attribute__((swift_name("resultId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BlockSeal.Companion")))
@interface FlowBlockSealCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBlockSealCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CadenceBase64ListSerializer")))
@interface FlowCadenceBase64ListSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSArray<FlowCadenceValue *> *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(NSArray<FlowCadenceValue *> *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CadenceBase64Serializer")))
@interface FlowCadenceBase64Serializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)cadenceBase64Serializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCadenceBase64Serializer *shared __attribute__((swift_name("shared")));
- (FlowCadenceValue *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowCadenceValue *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Chunk")))
@interface FlowChunk : FlowBase
- (instancetype)initWithBlockId:(NSString *)blockId collectionIndex:(NSString *)collectionIndex startState:(FlowBase64ByteArray *)startState endState:(FlowBase64ByteArray *)endState eventCollection:(FlowBase64ByteArray *)eventCollection index:(NSString *)index numberOfTransactions:(NSString *)numberOfTransactions totalComputationUsed:(NSString *)totalComputationUsed __attribute__((swift_name("init(blockId:collectionIndex:startState:endState:eventCollection:index:numberOfTransactions:totalComputationUsed:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowChunkCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBase64ByteArray *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBase64ByteArray *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBase64ByteArray *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component7 __attribute__((swift_name("component7()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component8 __attribute__((swift_name("component8()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowChunk *)doCopyBlockId:(NSString *)blockId collectionIndex:(NSString *)collectionIndex startState:(FlowBase64ByteArray *)startState endState:(FlowBase64ByteArray *)endState eventCollection:(FlowBase64ByteArray *)eventCollection index:(NSString *)index numberOfTransactions:(NSString *)numberOfTransactions totalComputationUsed:(NSString *)totalComputationUsed __attribute__((swift_name("doCopy(blockId:collectionIndex:startState:endState:eventCollection:index:numberOfTransactions:totalComputationUsed:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *blockId __attribute__((swift_name("blockId")));
@property (readonly) NSString *collectionIndex __attribute__((swift_name("collectionIndex")));
@property (readonly) FlowBase64ByteArray *endState __attribute__((swift_name("endState")));
@property (readonly) FlowBase64ByteArray *eventCollection __attribute__((swift_name("eventCollection")));
@property (readonly) NSString *index __attribute__((swift_name("index")));
@property (readonly) NSString *numberOfTransactions __attribute__((swift_name("numberOfTransactions")));
@property (readonly) FlowBase64ByteArray *startState __attribute__((swift_name("startState")));
@property (readonly) NSString *totalComputationUsed __attribute__((swift_name("totalComputationUsed")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Chunk.Companion")))
@interface FlowChunkCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowChunkCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Collection")))
@interface FlowCollection : FlowBase
- (instancetype)initWithId:(NSString *)id expandable:(FlowCollectionExpandable *)expandable transactions:(NSArray<FlowTransaction *> * _Nullable)transactions links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(id:expandable:transactions:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCollectionCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCollectionExpandable *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowTransaction *> * _Nullable)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCollection *)doCopyId:(NSString *)id expandable:(FlowCollectionExpandable *)expandable transactions:(NSArray<FlowTransaction *> * _Nullable)transactions links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(id:expandable:transactions:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowCollectionExpandable *expandable __attribute__((swift_name("expandable")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@property (readonly) NSArray<FlowTransaction *> * _Nullable transactions __attribute__((swift_name("transactions")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Collection.Companion")))
@interface FlowCollectionCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCollectionCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CollectionExpandable")))
@interface FlowCollectionExpandable : FlowBase
- (instancetype)initWithTransactions:(NSArray<NSString *> * _Nullable)transactions __attribute__((swift_name("init(transactions:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCollectionExpandableCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<NSString *> * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCollectionExpandable *)doCopyTransactions:(NSArray<NSString *> * _Nullable)transactions __attribute__((swift_name("doCopy(transactions:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<NSString *> * _Nullable transactions __attribute__((swift_name("transactions")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CollectionExpandable.Companion")))
@interface FlowCollectionExpandableCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCollectionExpandableCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CollectionGuarantee")))
@interface FlowCollectionGuarantee : FlowBase
- (instancetype)initWithCollectionId:(NSString *)collectionId signerIds:(NSArray<NSString *> * _Nullable)signerIds signature:(FlowBase64ByteArray *)signature __attribute__((swift_name("init(collectionId:signerIds:signature:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowCollectionGuaranteeCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<NSString *> * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBase64ByteArray *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCollectionGuarantee *)doCopyCollectionId:(NSString *)collectionId signerIds:(NSArray<NSString *> * _Nullable)signerIds signature:(FlowBase64ByteArray *)signature __attribute__((swift_name("doCopy(collectionId:signerIds:signature:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *collectionId __attribute__((swift_name("collectionId")));
@property (readonly) FlowBase64ByteArray *signature __attribute__((swift_name("signature")));
@property (readonly) NSArray<NSString *> * _Nullable signerIds __attribute__((swift_name("signerIds")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CollectionGuarantee.Companion")))
@interface FlowCollectionGuaranteeCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCollectionGuaranteeCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CompareTransactionSignature")))
@interface FlowCompareTransactionSignature : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) FlowCompareTransactionSignatureCompanion *companion __attribute__((swift_name("companion")));
@end;

__attribute__((swift_name("KotlinComparator")))
@protocol FlowKotlinComparator
@required
- (int32_t)compareA:(id _Nullable)a b:(id _Nullable)b __attribute__((swift_name("compare(a:b:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CompareTransactionSignature.Companion")))
@interface FlowCompareTransactionSignatureCompanion : FlowBase <FlowKotlinComparator>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowCompareTransactionSignatureCompanion *shared __attribute__((swift_name("shared")));
- (int32_t)compareA:(FlowTransactionSignature *)a b:(FlowTransactionSignature *)b __attribute__((swift_name("compare(a:b:)")));
@end;

__attribute__((swift_name("DomainTag")))
@interface FlowDomainTag : FlowBase
@property (readonly) FlowKotlinByteArray *bytes __attribute__((swift_name("bytes")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DomainTag.AccountProof")))
@interface FlowDomainTagAccountProof : FlowDomainTag
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)accountProof __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowDomainTagAccountProof *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DomainTag.Custom")))
@interface FlowDomainTagCustom : FlowDomainTag
- (instancetype)initWithTag:(NSString *)tag __attribute__((swift_name("init(tag:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowDomainTagCustom *)doCopyTag:(NSString *)tag __attribute__((swift_name("doCopy(tag:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DomainTag.Transaction")))
@interface FlowDomainTagTransaction : FlowDomainTag
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)transaction __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowDomainTagTransaction *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DomainTag.User")))
@interface FlowDomainTagUser : FlowDomainTag
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)user __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowDomainTagUser *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Error")))
@interface FlowError : FlowBase
- (instancetype)initWithCode:(FlowInt * _Nullable)code message:(NSString * _Nullable)message __attribute__((swift_name("init(code:message:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowErrorCompanion *companion __attribute__((swift_name("companion")));
- (FlowInt * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowError *)doCopyCode:(FlowInt * _Nullable)code message:(NSString * _Nullable)message __attribute__((swift_name("doCopy(code:message:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowInt * _Nullable code __attribute__((swift_name("code")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Error.Companion")))
@interface FlowErrorCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowErrorCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Event")))
@interface FlowEvent : FlowBase
- (instancetype)initWithType:(NSString *)type transactionId:(NSString *)transactionId transactionIndex:(NSString *)transactionIndex eventIndex:(NSString *)eventIndex payload:(FlowCadenceValue *)payload __attribute__((swift_name("init(type:transactionId:transactionIndex:eventIndex:payload:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowEventCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowCadenceValue *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowEvent *)doCopyType:(NSString *)type transactionId:(NSString *)transactionId transactionIndex:(NSString *)transactionIndex eventIndex:(NSString *)eventIndex payload:(FlowCadenceValue *)payload __attribute__((swift_name("doCopy(type:transactionId:transactionIndex:eventIndex:payload:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *eventIndex __attribute__((swift_name("eventIndex")));
@property (readonly) FlowCadenceValue *payload __attribute__((swift_name("payload")));
@property (readonly) NSString *transactionId __attribute__((swift_name("transactionId")));
@property (readonly) NSString *transactionIndex __attribute__((swift_name("transactionIndex")));
@property (readonly) NSString *type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Event.Companion")))
@interface FlowEventCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowEventCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExecutionResult")))
@interface FlowExecutionResult : FlowBase
- (instancetype)initWithId:(NSString *)id blockId:(NSString *)blockId events:(NSArray<FlowEvent *> *)events previousResultId:(NSString * _Nullable)previousResultId chunks:(NSArray<FlowChunk *> * _Nullable)chunks links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(id:blockId:events:previousResultId:chunks:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowExecutionResultCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowEvent *> *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowChunk *> * _Nullable)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowExecutionResult *)doCopyId:(NSString *)id blockId:(NSString *)blockId events:(NSArray<FlowEvent *> *)events previousResultId:(NSString * _Nullable)previousResultId chunks:(NSArray<FlowChunk *> * _Nullable)chunks links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(id:blockId:events:previousResultId:chunks:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *blockId __attribute__((swift_name("blockId")));
@property (readonly) NSArray<FlowChunk *> * _Nullable chunks __attribute__((swift_name("chunks")));
@property (readonly) NSArray<FlowEvent *> *events __attribute__((swift_name("events")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@property (readonly) NSString * _Nullable previousResultId __attribute__((swift_name("previousResultId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExecutionResult.Companion")))
@interface FlowExecutionResultCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowExecutionResultCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HashingAlgorithm")))
@interface FlowHashingAlgorithm : FlowKotlinEnum<FlowHashingAlgorithm *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowHashingAlgorithmCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowHashingAlgorithm *sha2256 __attribute__((swift_name("sha2256")));
@property (class, readonly) FlowHashingAlgorithm *sha2384 __attribute__((swift_name("sha2384")));
@property (class, readonly) FlowHashingAlgorithm *sha3256 __attribute__((swift_name("sha3256")));
@property (class, readonly) FlowHashingAlgorithm *sha3384 __attribute__((swift_name("sha3384")));
@property (class, readonly) FlowHashingAlgorithm *kmac128BlsBls12381 __attribute__((swift_name("kmac128BlsBls12381")));
+ (FlowKotlinArray<FlowHashingAlgorithm *> *)values __attribute__((swift_name("values()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HashingAlgorithm.Companion")))
@interface FlowHashingAlgorithmCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowHashingAlgorithmCompanion *shared __attribute__((swift_name("shared")));
- (FlowHashingAlgorithm * _Nullable)decodeData:(id _Nullable)data __attribute__((swift_name("decode(data:)")));
- (NSString * _Nullable)encodeData:(id _Nullable)data __attribute__((swift_name("encode(data:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Links")))
@interface FlowLinks : FlowBase
- (instancetype)initWithSelf:(NSString * _Nullable)self __attribute__((swift_name("init(self:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowLinksCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks *)doCopySelf:(NSString * _Nullable)self __attribute__((swift_name("doCopy(self:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable self __attribute__((swift_name("self")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Links.Companion")))
@interface FlowLinksCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowLinksCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProposalKey")))
@interface FlowProposalKey : FlowBase
- (instancetype)initWithAddress:(NSString *)address keyIndex:(int32_t)keyIndex sequenceNumber:(FlowBignumBigInteger *)sequenceNumber __attribute__((swift_name("init(address:keyIndex:sequenceNumber:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowProposalKeyCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumBigInteger *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowProposalKey *)doCopyAddress:(NSString *)address keyIndex:(int32_t)keyIndex sequenceNumber:(FlowBignumBigInteger *)sequenceNumber __attribute__((swift_name("doCopy(address:keyIndex:sequenceNumber:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) int32_t keyIndex __attribute__((swift_name("keyIndex")));
@property (readonly) FlowBignumBigInteger *sequenceNumber __attribute__((swift_name("sequenceNumber")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProposalKey.Companion")))
@interface FlowProposalKeyCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowProposalKeyCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ScriptsPostRequest")))
@interface FlowScriptsPostRequest : FlowBase
- (instancetype)initWithScript:(NSString * _Nullable)script arguments:(NSArray<NSString *> * _Nullable)arguments __attribute__((swift_name("init(script:arguments:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowScriptsPostRequestCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<NSString *> * _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowScriptsPostRequest *)doCopyScript:(NSString * _Nullable)script arguments:(NSArray<NSString *> * _Nullable)arguments __attribute__((swift_name("doCopy(script:arguments:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<NSString *> * _Nullable arguments __attribute__((swift_name("arguments")));
@property (readonly) NSString * _Nullable script __attribute__((swift_name("script")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ScriptsPostRequest.Companion")))
@interface FlowScriptsPostRequestCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowScriptsPostRequestCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ScriptsPostResponse")))
@interface FlowScriptsPostResponse : FlowBase
- (instancetype)initWithValue:(FlowBase64ByteArray * _Nullable)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowScriptsPostResponseCompanion *companion __attribute__((swift_name("companion")));
- (FlowBase64ByteArray * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowScriptsPostResponse *)doCopyValue:(FlowBase64ByteArray * _Nullable)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBase64ByteArray * _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ScriptsPostResponse.Companion")))
@interface FlowScriptsPostResponseCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowScriptsPostResponseCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Signer")))
@protocol FlowSigner
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)signBytes:(FlowKotlinByteArray *)bytes completionHandler:(void (^)(FlowKotlinByteArray * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("sign(bytes:completionHandler:)")));
@property NSString *address __attribute__((swift_name("address")));
@property int32_t keyIndex __attribute__((swift_name("keyIndex")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SigningAlgorithm")))
@interface FlowSigningAlgorithm : FlowKotlinEnum<FlowSigningAlgorithm *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowSigningAlgorithmCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowSigningAlgorithm *blsBls12381 __attribute__((swift_name("blsBls12381")));
@property (class, readonly) FlowSigningAlgorithm *ecdsaP256 __attribute__((swift_name("ecdsaP256")));
@property (class, readonly) FlowSigningAlgorithm *ecdsaSecp256k1 __attribute__((swift_name("ecdsaSecp256k1")));
+ (FlowKotlinArray<FlowSigningAlgorithm *> *)values __attribute__((swift_name("values()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SigningAlgorithm.Companion")))
@interface FlowSigningAlgorithmCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowSigningAlgorithmCompanion *shared __attribute__((swift_name("shared")));
- (FlowSigningAlgorithm * _Nullable)decodeData:(id _Nullable)data __attribute__((swift_name("decode(data:)")));
- (NSString * _Nullable)encodeData:(id _Nullable)data __attribute__((swift_name("encode(data:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StringIntSerializer")))
@interface FlowStringIntSerializer : FlowBase <FlowKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)stringIntSerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowStringIntSerializer *shared __attribute__((swift_name("shared")));
- (FlowInt *)deserializeDecoder:(id<FlowKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<FlowKotlinx_serialization_coreEncoder>)encoder value:(FlowInt *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<FlowKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Transaction")))
@interface FlowTransaction : FlowBase
- (instancetype)initWithId:(NSString * _Nullable)id script:(NSString *)script arguments:(NSArray<FlowCadenceValue *> *)arguments referenceBlockId:(NSString *)referenceBlockId gasLimit:(FlowBignumBigInteger *)gasLimit payer:(NSString *)payer proposalKey:(FlowProposalKey *)proposalKey authorizers:(NSArray<NSString *> *)authorizers payloadSignatures:(NSArray<FlowTransactionSignature *> *)payloadSignatures envelopeSignatures:(NSArray<FlowTransactionSignature *> *)envelopeSignatures expandable:(FlowTransactionExpandable * _Nullable)expandable result:(FlowTransactionResult * _Nullable)result links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(id:script:arguments:referenceBlockId:gasLimit:payer:proposalKey:authorizers:payloadSignatures:envelopeSignatures:expandable:result:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowTransactionCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowTransactionSignature *> *)component10 __attribute__((swift_name("component10()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionExpandable * _Nullable)component11 __attribute__((swift_name("component11()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionResult * _Nullable)component12 __attribute__((swift_name("component12()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component13 __attribute__((swift_name("component13()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowCadenceValue *> *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumBigInteger *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowProposalKey *)component7 __attribute__((swift_name("component7()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<NSString *> *)component8 __attribute__((swift_name("component8()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowTransactionSignature *> *)component9 __attribute__((swift_name("component9()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransaction *)doCopyId:(NSString * _Nullable)id script:(NSString *)script arguments:(NSArray<FlowCadenceValue *> *)arguments referenceBlockId:(NSString *)referenceBlockId gasLimit:(FlowBignumBigInteger *)gasLimit payer:(NSString *)payer proposalKey:(FlowProposalKey *)proposalKey authorizers:(NSArray<NSString *> *)authorizers payloadSignatures:(NSArray<FlowTransactionSignature *> *)payloadSignatures envelopeSignatures:(NSArray<FlowTransactionSignature *> *)envelopeSignatures expandable:(FlowTransactionExpandable * _Nullable)expandable result:(FlowTransactionResult * _Nullable)result links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(id:script:arguments:referenceBlockId:gasLimit:payer:proposalKey:authorizers:payloadSignatures:envelopeSignatures:expandable:result:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)signSigners:(NSArray<id<FlowSigner>> *)signers completionHandler:(void (^)(FlowTransaction * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("sign(signers:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)signEnvelopeSigners:(NSArray<id<FlowSigner>> *)signers completionHandler:(void (^)(FlowTransaction * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("signEnvelope(signers:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)signPayloadSigners:(NSArray<id<FlowSigner>> *)signers completionHandler:(void (^)(FlowTransaction * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("signPayload(signers:completionHandler:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<FlowCadenceValue *> *arguments __attribute__((swift_name("arguments")));
@property (readonly) NSArray<NSString *> *authorizers __attribute__((swift_name("authorizers")));
@property (readonly) NSArray<FlowTransactionSignature *> *envelopeSignatures __attribute__((swift_name("envelopeSignatures")));
@property (readonly) FlowTransactionExpandable * _Nullable expandable __attribute__((swift_name("expandable")));
@property (readonly) FlowBignumBigInteger *gasLimit __attribute__((swift_name("gasLimit")));
@property (readonly) NSString * _Nullable id __attribute__((swift_name("id")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@property (readonly) NSString *payer __attribute__((swift_name("payer")));
@property (readonly) NSArray<FlowTransactionSignature *> *payloadSignatures __attribute__((swift_name("payloadSignatures")));
@property (readonly) FlowProposalKey *proposalKey __attribute__((swift_name("proposalKey")));
@property (readonly) NSString *referenceBlockId __attribute__((swift_name("referenceBlockId")));
@property (readonly) FlowTransactionResult * _Nullable result __attribute__((swift_name("result")));
@property (readonly) NSString *script __attribute__((swift_name("script")));
@property (readonly) NSDictionary<NSString *, FlowInt *> *signers __attribute__((swift_name("signers")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Transaction.Companion")))
@interface FlowTransactionCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowTransactionCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionExecution")))
@interface FlowTransactionExecution : FlowKotlinEnum<FlowTransactionExecution *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowTransactionExecutionCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowTransactionExecution *pending __attribute__((swift_name("pending")));
@property (class, readonly) FlowTransactionExecution *success __attribute__((swift_name("success")));
@property (class, readonly) FlowTransactionExecution *failure __attribute__((swift_name("failure")));
+ (FlowKotlinArray<FlowTransactionExecution *> *)values __attribute__((swift_name("values()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionExecution.Companion")))
@interface FlowTransactionExecutionCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowTransactionExecutionCompanion *shared __attribute__((swift_name("shared")));
- (FlowTransactionExecution * _Nullable)decodeData:(id _Nullable)data __attribute__((swift_name("decode(data:)")));
- (NSString * _Nullable)encodeData:(id _Nullable)data __attribute__((swift_name("encode(data:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionExpandable")))
@interface FlowTransactionExpandable : FlowBase
- (instancetype)initWithResult:(NSString * _Nullable)result __attribute__((swift_name("init(result:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowTransactionExpandableCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionExpandable *)doCopyResult:(NSString * _Nullable)result __attribute__((swift_name("doCopy(result:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable result __attribute__((swift_name("result")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionExpandable.Companion")))
@interface FlowTransactionExpandableCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowTransactionExpandableCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionResult")))
@interface FlowTransactionResult : FlowBase
- (instancetype)initWithBlockId:(NSString *)blockId status:(FlowTransactionStatus *)status statusCode:(int32_t)statusCode errorMessage:(NSString *)errorMessage computationUsed:(NSString *)computationUsed events:(NSArray<FlowEvent *> *)events execution:(FlowTransactionExecution * _Nullable)execution links:(FlowLinks * _Nullable)links __attribute__((swift_name("init(blockId:status:statusCode:errorMessage:computationUsed:events:execution:links:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowTransactionResultCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionStatus *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSArray<FlowEvent *> *)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionExecution * _Nullable)component7 __attribute__((swift_name("component7()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowLinks * _Nullable)component8 __attribute__((swift_name("component8()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionResult *)doCopyBlockId:(NSString *)blockId status:(FlowTransactionStatus *)status statusCode:(int32_t)statusCode errorMessage:(NSString *)errorMessage computationUsed:(NSString *)computationUsed events:(NSArray<FlowEvent *> *)events execution:(FlowTransactionExecution * _Nullable)execution links:(FlowLinks * _Nullable)links __attribute__((swift_name("doCopy(blockId:status:statusCode:errorMessage:computationUsed:events:execution:links:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *blockId __attribute__((swift_name("blockId")));
@property (readonly) NSString *computationUsed __attribute__((swift_name("computationUsed")));
@property (readonly) NSString *errorMessage __attribute__((swift_name("errorMessage")));
@property (readonly) NSArray<FlowEvent *> *events __attribute__((swift_name("events")));
@property (readonly) FlowTransactionExecution * _Nullable execution __attribute__((swift_name("execution")));
@property (readonly) FlowLinks * _Nullable links __attribute__((swift_name("links")));
@property (readonly) FlowTransactionStatus *status __attribute__((swift_name("status")));
@property (readonly) int32_t statusCode __attribute__((swift_name("statusCode")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionResult.Companion")))
@interface FlowTransactionResultCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowTransactionResultCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionSignature")))
@interface FlowTransactionSignature : FlowBase
- (instancetype)initWithAddress:(NSString *)address keyIndex:(int32_t)keyIndex signature:(NSString *)signature signerIndex:(int32_t)signerIndex __attribute__((swift_name("init(address:keyIndex:signature:signerIndex:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowTransactionSignatureCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowTransactionSignature *)doCopyAddress:(NSString *)address keyIndex:(int32_t)keyIndex signature:(NSString *)signature signerIndex:(int32_t)signerIndex __attribute__((swift_name("doCopy(address:keyIndex:signature:signerIndex:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *address __attribute__((swift_name("address")));
@property (readonly) int32_t keyIndex __attribute__((swift_name("keyIndex")));
@property (readonly) NSString *signature __attribute__((swift_name("signature")));
@property int32_t signerIndex __attribute__((swift_name("signerIndex")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionSignature.Companion")))
@interface FlowTransactionSignatureCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowTransactionSignatureCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionStatus")))
@interface FlowTransactionStatus : FlowKotlinEnum<FlowTransactionStatus *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowTransactionStatusCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowTransactionStatus *pending __attribute__((swift_name("pending")));
@property (class, readonly) FlowTransactionStatus *finalized __attribute__((swift_name("finalized")));
@property (class, readonly) FlowTransactionStatus *executed __attribute__((swift_name("executed")));
@property (class, readonly) FlowTransactionStatus *sealed __attribute__((swift_name("sealed")));
@property (class, readonly) FlowTransactionStatus *expired __attribute__((swift_name("expired")));
+ (FlowKotlinArray<FlowTransactionStatus *> *)values __attribute__((swift_name("values()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TransactionStatus.Companion")))
@interface FlowTransactionStatusCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowTransactionStatusCompanion *shared __attribute__((swift_name("shared")));
- (FlowTransactionStatus * _Nullable)decodeData:(id _Nullable)data __attribute__((swift_name("decode(data:)")));
- (NSString * _Nullable)encodeData:(id _Nullable)data __attribute__((swift_name("encode(data:)")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

@interface FlowFlowApi (Extensions)

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getAccountAddress:(NSString *)address completionHandler:(void (^)(FlowAccount * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getAccount(address:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface FlowKotlinByteArray : FlowBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(FlowByte *(^)(FlowInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (FlowKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

@interface FlowKotlinByteArray (Extensions)
- (FlowRLPType *)decodeRLP __attribute__((swift_name("decodeRLP()")));
- (FlowKotlinByteArray *)paddingZeroLeftBlockSize:(int32_t)blockSize __attribute__((swift_name("paddingZeroLeft(blockSize:)")));
- (FlowKotlinByteArray *)paddingZeroRightBlockSize:(int32_t)blockSize __attribute__((swift_name("paddingZeroRight(blockSize:)")));
- (FlowKotlinByteArray *)removeLeadingZero __attribute__((swift_name("removeLeadingZero()")));
- (FlowRLPElement *)toRLP __attribute__((swift_name("toRLP()")));
- (NSString *)toBase64 __attribute__((swift_name("toBase64()")));
- (NSString *)toHexString __attribute__((swift_name("toHexString()")));
@end;

@interface FlowRLPType (Extensions)
- (FlowKotlinByteArray *)encode __attribute__((swift_name("encode()")));
@end;

@interface FlowRLPElement (Extensions)
- (int8_t)toByteFromRLP __attribute__((swift_name("toByteFromRLP()")));
- (int32_t)toIntFromRLP __attribute__((swift_name("toIntFromRLP()")));
- (NSString *)toStringFromRLP __attribute__((swift_name("toStringFromRLP()")));
- (FlowBignumBigInteger *)toUnsignedBigIntegerFromRLP __attribute__((swift_name("toUnsignedBigIntegerFromRLP()")));
@end;

__attribute__((swift_name("BignumBigNumber")))
@protocol FlowBignumBigNumber
@required
- (id<FlowBignumBigNumber>)abs __attribute__((swift_name("abs()")));
- (id<FlowBignumBigNumber>)addOther:(id<FlowBignumBigNumber>)other __attribute__((swift_name("add(other:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (id<FlowBignumBigNumber>)divideOther:(id<FlowBignumBigNumber>)other __attribute__((swift_name("divide(other:)")));
- (FlowKotlinPair<id<FlowBignumBigNumber>, id<FlowBignumBigNumber>> *)divideAndRemainderOther:(id<FlowBignumBigNumber>)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (id<FlowBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (id<FlowBignumBigNumber>)multiplyOther:(id<FlowBignumBigNumber>)other __attribute__((swift_name("multiply(other:)")));
- (id<FlowBignumBigNumber>)negate __attribute__((swift_name("negate()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (id<FlowBignumBigNumber>)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (id<FlowBignumBigNumber>)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (id<FlowBignumBigNumber>)remainderOther:(id<FlowBignumBigNumber>)other __attribute__((swift_name("remainder(other:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (id<FlowBignumBigNumber>)subtractOther:(id<FlowBignumBigNumber>)other __attribute__((swift_name("subtract(other:)")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (id<FlowBignumBigNumber>)unaryMinus __attribute__((swift_name("unaryMinus()")));
@property (readonly) BOOL isNegative __attribute__((swift_name("isNegative")));
@property (readonly) BOOL isPositive __attribute__((swift_name("isPositive")));
@end;

__attribute__((swift_name("BignumBitwiseCapable")))
@protocol FlowBignumBitwiseCapable
@required
- (id _Nullable)andOther:(id _Nullable)other __attribute__((swift_name("and(other:)")));
- (BOOL)bitAtPosition:(int64_t)position __attribute__((swift_name("bitAt(position:)")));
- (id _Nullable)not __attribute__((swift_name("not()")));
- (id _Nullable)orOther:(id _Nullable)other __attribute__((swift_name("or(other:)")));
- (id _Nullable)setBitAtPosition:(int64_t)position bit:(BOOL)bit __attribute__((swift_name("setBitAt(position:bit:)")));
- (id _Nullable)shlPlaces:(int32_t)places __attribute__((swift_name("shl(places:)")));
- (id _Nullable)shrPlaces:(int32_t)places __attribute__((swift_name("shr(places:)")));
- (id _Nullable)xorOther:(id _Nullable)other __attribute__((swift_name("xor(other:)")));
@end;

__attribute__((swift_name("BignumByteArraySerializable")))
@protocol FlowBignumByteArraySerializable
@required
- (FlowKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));
- (id)toUByteArray __attribute__((swift_name("toUByteArray()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger")))
@interface FlowBignumBigInteger : FlowBase <FlowBignumBigNumber, FlowBignumBitwiseCapable, FlowKotlinComparable, FlowBignumByteArraySerializable>
- (instancetype)initWithLong:(int64_t)long_ __attribute__((swift_name("init(long:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithInt:(int32_t)int_ __attribute__((swift_name("init(int:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithShort:(int16_t)short_ __attribute__((swift_name("init(short:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithByte:(int8_t)byte __attribute__((swift_name("init(byte:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBignumBigIntegerCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumBigInteger *)abs __attribute__((swift_name("abs()")));
- (FlowBignumBigInteger *)addOther:(FlowBignumBigInteger *)other __attribute__((swift_name("add(other:)")));
- (FlowBignumBigInteger *)andOther:(FlowBignumBigInteger *)other __attribute__((swift_name("and(other:)")));
- (BOOL)bitAtPosition:(int64_t)position __attribute__((swift_name("bitAt(position:)")));
- (int8_t)byteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("byteValue(exactRequired:)")));
- (int32_t)compareOther:(FlowBignumBigInteger *)other __attribute__((swift_name("compare(other:)")));
- (int32_t)compareDoubleAndBigIntDouble:(double)double_ comparisonBlock:(FlowInt *(^)(FlowBignumBigInteger *))comparisonBlock __attribute__((swift_name("compareDoubleAndBigInt(double:comparisonBlock:)")));
- (int32_t)compareFloatAndBigIntFloat:(float)float_ comparisonBlock:(FlowInt *(^)(FlowBignumBigInteger *))comparisonBlock __attribute__((swift_name("compareFloatAndBigInt(float:comparisonBlock:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (int32_t)compareToOther:(id)other __attribute__((swift_name("compareTo(other:)")));
- (FlowBignumBigInteger *)dec __attribute__((swift_name("dec()")));
- (FlowBignumBigInteger *)divideOther:(FlowBignumBigInteger *)other __attribute__((swift_name("divide(other:)")));
- (FlowKotlinPair<FlowBignumBigInteger *, FlowBignumBigInteger *> *)divideAndRemainderOther:(FlowBignumBigInteger *)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (FlowBignumBigIntegerQuotientAndRemainder *)divremOther:(FlowBignumBigInteger *)other __attribute__((swift_name("divrem(other:)")));
- (double)doubleValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("doubleValue(exactRequired:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (FlowBignumBigInteger *)factorial __attribute__((swift_name("factorial()")));
- (float)floatValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("floatValue(exactRequired:)")));
- (FlowBignumBigInteger *)gcdOther:(FlowBignumBigInteger *)other __attribute__((swift_name("gcd(other:)")));
- (id)getBackingArrayCopy __attribute__((swift_name("getBackingArrayCopy()")));
- (id<FlowBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (FlowBignumBigInteger *)getInstance __attribute__((swift_name("getInstance()")));
- (FlowBignumSign *)getSign __attribute__((swift_name("getSign()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (FlowBignumBigInteger *)inc __attribute__((swift_name("inc()")));
- (int32_t)intValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("intValue(exactRequired:)")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (int64_t)longValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("longValue(exactRequired:)")));
- (FlowBignumBigInteger *)modModulo:(FlowBignumBigInteger *)modulo __attribute__((swift_name("mod(modulo:)")));
- (FlowBignumBigInteger *)modInverseModulo:(FlowBignumBigInteger *)modulo __attribute__((swift_name("modInverse(modulo:)")));
- (FlowBignumBigInteger *)multiplyOther:(FlowBignumBigInteger *)other __attribute__((swift_name("multiply(other:)")));
- (FlowBignumBigInteger *)negate __attribute__((swift_name("negate()")));
- (FlowBignumBigInteger *)not __attribute__((swift_name("not()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (FlowBignumBigInteger *)orOther:(FlowBignumBigInteger *)other __attribute__((swift_name("or(other:)")));
- (FlowBignumBigInteger *)powExponent__:(FlowBignumBigInteger *)exponent __attribute__((swift_name("pow(exponent__:)")));
- (FlowBignumBigInteger *)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (FlowBignumBigInteger *)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (FlowBignumBigIntegerBigIntegerRange *)rangeToOther:(FlowBignumBigInteger *)other __attribute__((swift_name("rangeTo(other:)")));
- (FlowBignumBigInteger *)remainderOther:(FlowBignumBigInteger *)other __attribute__((swift_name("remainder(other:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (FlowBignumBigInteger *)setBitAtPosition:(int64_t)position bit:(BOOL)bit __attribute__((swift_name("setBitAt(position:bit:)")));
- (FlowBignumBigInteger *)shlPlaces:(int32_t)places __attribute__((swift_name("shl(places:)")));
- (int16_t)shortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("shortValue(exactRequired:)")));
- (FlowBignumBigInteger *)shrPlaces:(int32_t)places __attribute__((swift_name("shr(places:)")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (FlowBignumBigInteger *)sqrt __attribute__((swift_name("sqrt()")));
- (FlowBignumBigIntegerSqareRootAndRemainder *)sqrtAndRemainder __attribute__((swift_name("sqrtAndRemainder()")));
- (FlowBignumBigInteger *)subtractOther:(FlowBignumBigInteger *)other __attribute__((swift_name("subtract(other:)")));
- (NSString *)timesChar:(unichar)char_ __attribute__((swift_name("times(char:)")));
- (FlowKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));
- (FlowBignumModularBigInteger *)toModularBigIntegerModulo:(FlowBignumBigInteger *)modulo __attribute__((swift_name("toModularBigInteger(modulo:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (id)toUByteArray __attribute__((swift_name("toUByteArray()")));
- (uint8_t)ubyteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ubyteValue(exactRequired:)")));
- (uint32_t)uintValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("uintValue(exactRequired:)")));
- (uint64_t)ulongValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ulongValue(exactRequired:)")));
- (FlowBignumBigInteger *)unaryMinus __attribute__((swift_name("unaryMinus()")));
- (uint16_t)ushortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ushortValue(exactRequired:)")));
- (FlowBignumBigInteger *)xorOther:(FlowBignumBigInteger *)other __attribute__((swift_name("xor(other:)")));
@property (readonly) int32_t numberOfWords __attribute__((swift_name("numberOfWords")));
@property NSString * _Nullable stringRepresentation __attribute__((swift_name("stringRepresentation")));
@end;

@interface FlowBignumBigInteger (Extensions)
- (FlowRLPElement *)toRLP __attribute__((swift_name("toRLP()")));
@end;

@interface FlowCadenceCompositeValue (Extensions)
- (id _Nullable)getFieldKey:(NSString *)key __attribute__((swift_name("getField(key:)")));
- (NSDictionary<NSString *, id> *)toMap __attribute__((swift_name("toMap()")));
@end;

@interface FlowTransaction (Extensions)
- (FlowKotlinByteArray *)envelopeMessage __attribute__((swift_name("envelopeMessage()")));
- (NSArray<FlowRLPType *> *)payload __attribute__((swift_name("payload()")));
- (FlowKotlinByteArray *)payloadMessage __attribute__((swift_name("payloadMessage()")));
- (FlowRLPElement *)toRLP __attribute__((swift_name("toRLP()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RLPTypeConverterKt")))
@interface FlowRLPTypeConverterKt : FlowBase
+ (FlowKotlinByteArray *)toByteArray:(int32_t)receiver __attribute__((swift_name("toByteArray(_:)")));
+ (FlowKotlinByteArray *)toMinimalByteArray:(int32_t)receiver __attribute__((swift_name("toMinimalByteArray(_:)")));
+ (FlowRLPElement *)toRLP:(int8_t)receiver __attribute__((swift_name("toRLP(_:)")));
+ (FlowRLPElement *)toRLP_:(int32_t)receiver __attribute__((swift_name("toRLP(__:)")));
+ (FlowRLPElement *)toRLP__:(NSString *)receiver __attribute__((swift_name("toRLP(___:)")));
+ (FlowRLPElement *)toRLP___:(NSArray<FlowRLPType *> *)receiver __attribute__((swift_name("toRLP(____:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CadenceTypeKt")))
@interface FlowCadenceTypeKt : FlowBase
@property (class, readonly) NSString *TYPE_ACCOUNTKEY __attribute__((swift_name("TYPE_ACCOUNTKEY")));
@property (class, readonly) NSString *TYPE_ADDRESS __attribute__((swift_name("TYPE_ADDRESS")));
@property (class, readonly) NSString *TYPE_ANY __attribute__((swift_name("TYPE_ANY")));
@property (class, readonly) NSString *TYPE_ANYRESOURCE __attribute__((swift_name("TYPE_ANYRESOURCE")));
@property (class, readonly) NSString *TYPE_ANYSTRUCT __attribute__((swift_name("TYPE_ANYSTRUCT")));
@property (class, readonly) NSString *TYPE_ARRAY __attribute__((swift_name("TYPE_ARRAY")));
@property (class, readonly) NSString *TYPE_AUTHACCOUNT __attribute__((swift_name("TYPE_AUTHACCOUNT")));
@property (class, readonly) NSString *TYPE_AUTHACCOUNT_CONTRACTS __attribute__((swift_name("TYPE_AUTHACCOUNT_CONTRACTS")));
@property (class, readonly) NSString *TYPE_AUTHACCOUNT_KEYS __attribute__((swift_name("TYPE_AUTHACCOUNT_KEYS")));
@property (class, readonly) NSString *TYPE_BLOCK __attribute__((swift_name("TYPE_BLOCK")));
@property (class, readonly) NSString *TYPE_BOOLEAN __attribute__((swift_name("TYPE_BOOLEAN")));
@property (class, readonly) NSString *TYPE_BYTES __attribute__((swift_name("TYPE_BYTES")));
@property (class, readonly) NSString *TYPE_CAPABILITY __attribute__((swift_name("TYPE_CAPABILITY")));
@property (class, readonly) NSString *TYPE_CAPABILITYPATH __attribute__((swift_name("TYPE_CAPABILITYPATH")));
@property (class, readonly) NSString *TYPE_CHARACTER __attribute__((swift_name("TYPE_CHARACTER")));
@property (class, readonly) NSString *TYPE_CONSTANT_SIZED_ARRAY __attribute__((swift_name("TYPE_CONSTANT_SIZED_ARRAY")));
@property (class, readonly) NSString *TYPE_CONTRACT __attribute__((swift_name("TYPE_CONTRACT")));
@property (class, readonly) NSString *TYPE_CONTRACT_INTERFACE __attribute__((swift_name("TYPE_CONTRACT_INTERFACE")));
@property (class, readonly) NSString *TYPE_DEPLOYEDCONTRACT __attribute__((swift_name("TYPE_DEPLOYEDCONTRACT")));
@property (class, readonly) NSString *TYPE_DICTIONARY __attribute__((swift_name("TYPE_DICTIONARY")));
@property (class, readonly) NSString *TYPE_ENUM __attribute__((swift_name("TYPE_ENUM")));
@property (class, readonly) NSString *TYPE_EVENT __attribute__((swift_name("TYPE_EVENT")));
@property (class, readonly) NSString *TYPE_FIX64 __attribute__((swift_name("TYPE_FIX64")));
@property (class, readonly) NSString *TYPE_FIXEDPOINT __attribute__((swift_name("TYPE_FIXEDPOINT")));
@property (class, readonly) NSString *TYPE_FUNCTION __attribute__((swift_name("TYPE_FUNCTION")));
@property (class, readonly) NSString *TYPE_INT __attribute__((swift_name("TYPE_INT")));
@property (class, readonly) NSString *TYPE_INT128 __attribute__((swift_name("TYPE_INT128")));
@property (class, readonly) NSString *TYPE_INT16 __attribute__((swift_name("TYPE_INT16")));
@property (class, readonly) NSString *TYPE_INT256 __attribute__((swift_name("TYPE_INT256")));
@property (class, readonly) NSString *TYPE_INT32 __attribute__((swift_name("TYPE_INT32")));
@property (class, readonly) NSString *TYPE_INT64 __attribute__((swift_name("TYPE_INT64")));
@property (class, readonly) NSString *TYPE_INT8 __attribute__((swift_name("TYPE_INT8")));
@property (class, readonly) NSString *TYPE_INTEGER __attribute__((swift_name("TYPE_INTEGER")));
@property (class, readonly) NSString *TYPE_NEVER __attribute__((swift_name("TYPE_NEVER")));
@property (class, readonly) NSString *TYPE_NUMBER __attribute__((swift_name("TYPE_NUMBER")));
@property (class, readonly) NSString *TYPE_OPTIONAL __attribute__((swift_name("TYPE_OPTIONAL")));
@property (class, readonly) NSString *TYPE_PATH __attribute__((swift_name("TYPE_PATH")));
@property (class, readonly) NSString *TYPE_PRIVATEPATH __attribute__((swift_name("TYPE_PRIVATEPATH")));
@property (class, readonly) NSString *TYPE_PUBLICACCOUNT __attribute__((swift_name("TYPE_PUBLICACCOUNT")));
@property (class, readonly) NSString *TYPE_PUBLICACCOUNT_CONTRACTS __attribute__((swift_name("TYPE_PUBLICACCOUNT_CONTRACTS")));
@property (class, readonly) NSString *TYPE_PUBLICACCOUNT_KEYS __attribute__((swift_name("TYPE_PUBLICACCOUNT_KEYS")));
@property (class, readonly) NSString *TYPE_PUBLICPATH __attribute__((swift_name("TYPE_PUBLICPATH")));
@property (class, readonly) NSString *TYPE_REFERENCE __attribute__((swift_name("TYPE_REFERENCE")));
@property (class, readonly) NSString *TYPE_RESOURCE __attribute__((swift_name("TYPE_RESOURCE")));
@property (class, readonly) NSString *TYPE_RESOURCE_INTERFACE __attribute__((swift_name("TYPE_RESOURCE_INTERFACE")));
@property (class, readonly) NSString *TYPE_RESTRICTION __attribute__((swift_name("TYPE_RESTRICTION")));
@property (class, readonly) NSString *TYPE_SIGNEDFIXEDPOINT __attribute__((swift_name("TYPE_SIGNEDFIXEDPOINT")));
@property (class, readonly) NSString *TYPE_SIGNEDINTEGER __attribute__((swift_name("TYPE_SIGNEDINTEGER")));
@property (class, readonly) NSString *TYPE_SIGNEDNUMBER __attribute__((swift_name("TYPE_SIGNEDNUMBER")));
@property (class, readonly) NSString *TYPE_STORAGEPATH __attribute__((swift_name("TYPE_STORAGEPATH")));
@property (class, readonly) NSString *TYPE_STRING __attribute__((swift_name("TYPE_STRING")));
@property (class, readonly) NSString *TYPE_STRUCT __attribute__((swift_name("TYPE_STRUCT")));
@property (class, readonly) NSString *TYPE_STRUCT_INTERFACE __attribute__((swift_name("TYPE_STRUCT_INTERFACE")));
@property (class, readonly) NSString *TYPE_TYPE __attribute__((swift_name("TYPE_TYPE")));
@property (class, readonly) NSString *TYPE_UFIX64 __attribute__((swift_name("TYPE_UFIX64")));
@property (class, readonly) NSString *TYPE_UINT __attribute__((swift_name("TYPE_UINT")));
@property (class, readonly) NSString *TYPE_UINT128 __attribute__((swift_name("TYPE_UINT128")));
@property (class, readonly) NSString *TYPE_UINT16 __attribute__((swift_name("TYPE_UINT16")));
@property (class, readonly) NSString *TYPE_UINT256 __attribute__((swift_name("TYPE_UINT256")));
@property (class, readonly) NSString *TYPE_UINT32 __attribute__((swift_name("TYPE_UINT32")));
@property (class, readonly) NSString *TYPE_UINT64 __attribute__((swift_name("TYPE_UINT64")));
@property (class, readonly) NSString *TYPE_UINT8 __attribute__((swift_name("TYPE_UINT8")));
@property (class, readonly) NSString *TYPE_VARIABLE_SIZED_ARRAY __attribute__((swift_name("TYPE_VARIABLE_SIZED_ARRAY")));
@property (class, readonly) NSString *TYPE_VOID __attribute__((swift_name("TYPE_VOID")));
@property (class, readonly) NSString *TYPE_WORD16 __attribute__((swift_name("TYPE_WORD16")));
@property (class, readonly) NSString *TYPE_WORD32 __attribute__((swift_name("TYPE_WORD32")));
@property (class, readonly) NSString *TYPE_WORD64 __attribute__((swift_name("TYPE_WORD64")));
@property (class, readonly) NSString *TYPE_WORD8 __attribute__((swift_name("TYPE_WORD8")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ApiAbstractionsKt")))
@interface FlowApiAbstractionsKt : FlowBase
+ (NSString *)collectionDelimiterCollectionFormat:(NSString *)collectionFormat __attribute__((swift_name("collectionDelimiter(collectionFormat:)")));
+ (NSArray<NSString *> *)toMultiValueItems:(FlowKotlinArray<id> *)items collectionFormat:(NSString *)collectionFormat map:(NSString *(^)(id _Nullable))map __attribute__((swift_name("toMultiValue(items:collectionFormat:map:)")));
+ (NSArray<NSString *> *)toMultiValueItems:(id)items collectionFormat:(NSString *)collectionFormat map_:(NSString *(^)(id _Nullable))map __attribute__((swift_name("toMultiValue(items:collectionFormat:map_:)")));
@property (class, readonly) NSString *(^defaultMultiValueConverter)(id _Nullable) __attribute__((swift_name("defaultMultiValueConverter")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CadenceDecodeKt")))
@interface FlowCadenceDecodeKt : FlowBase
+ (NSString *)addHexPrefix:(NSString *)receiver __attribute__((swift_name("addHexPrefix(_:)")));
+ (NSArray<id> *)decode:(NSArray<FlowCadenceValue *> *)receiver __attribute__((swift_name("decode(_:)")));
+ (NSArray<id> *)decodeToAny:(NSArray<FlowCadenceValue *> *)receiver __attribute__((swift_name("decodeToAny(_:)")));
+ (NSArray<NSString *> *)encodeBase64:(NSArray<FlowCadenceValue *> *)receiver __attribute__((swift_name("encodeBase64(_:)")));
+ (NSString *)removeHexPrefix:(NSString *)receiver __attribute__((swift_name("removeHexPrefix(_:)")));
+ (FlowKotlinx_serialization_jsonJsonElement *)toJsonElement:(id _Nullable)receiver __attribute__((swift_name("toJsonElement(_:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CadenceKt")))
@interface FlowCadenceKt : FlowBase
+ (id _Nullable)getField:(NSArray<FlowCadenceCompositeAttribute *> *)receiver key:(NSString *)key __attribute__((swift_name("getField(_:key:)")));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface FlowKotlinIllegalStateException : FlowKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface FlowKotlinCancellationException : FlowKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface FlowKotlinArray<T> : FlowBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(FlowInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<FlowKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol FlowKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<FlowKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((swift_name("Ktor_ioCloseable")))
@protocol FlowKtor_ioCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClient")))
@interface FlowKtor_client_coreHttpClient : FlowBase <FlowKotlinx_coroutines_coreCoroutineScope, FlowKtor_ioCloseable>
- (instancetype)initWithEngine:(id<FlowKtor_client_coreHttpClientEngine>)engine userConfig:(FlowKtor_client_coreHttpClientConfig<FlowKtor_client_coreHttpClientEngineConfig *> *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (FlowKtor_client_coreHttpClient *)configBlock:(void (^)(FlowKtor_client_coreHttpClientConfig<id> *))block __attribute__((swift_name("config(block:)")));
- (BOOL)isSupportedCapability:(id<FlowKtor_client_coreHttpClientEngineCapability>)capability __attribute__((swift_name("isSupported(capability:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<FlowKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) id<FlowKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property (readonly) id<FlowKtor_client_coreHttpClientEngine> engine __attribute__((swift_name("engine")));
@property (readonly) FlowKtor_client_coreHttpClientEngineConfig *engineConfig __attribute__((swift_name("engineConfig")));
@property (readonly) FlowKtor_eventsEvents *monitor __attribute__((swift_name("monitor")));
@property (readonly) FlowKtor_client_coreHttpReceivePipeline *receivePipeline __attribute__((swift_name("receivePipeline")));
@property (readonly) FlowKtor_client_coreHttpRequestPipeline *requestPipeline __attribute__((swift_name("requestPipeline")));
@property (readonly) FlowKtor_client_coreHttpResponsePipeline *responsePipeline __attribute__((swift_name("responsePipeline")));
@property (readonly) FlowKtor_client_coreHttpSendPipeline *sendPipeline __attribute__((swift_name("sendPipeline")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol FlowKotlinx_serialization_coreEncoder
@required
- (id<FlowKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<FlowKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<FlowKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) FlowKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol FlowKotlinx_serialization_coreSerialDescriptor
@required
- (NSArray<id<FlowKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<FlowKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) NSArray<id<FlowKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));
@property (readonly) FlowKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol FlowKotlinx_serialization_coreDecoder
@required
- (id<FlowKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<FlowKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (FlowKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) FlowKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigDecimal")))
@interface FlowBignumBigDecimal : FlowBase <FlowBignumBigNumber, FlowKotlinComparable>
@property (class, readonly, getter=companion) FlowBignumBigDecimalCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumBigDecimal *)abs __attribute__((swift_name("abs()")));
- (FlowBignumBigDecimal *)addOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("add(other:)")));
- (FlowBignumBigDecimal *)addOther:(FlowBignumBigDecimal *)other decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("add(other:decimalMode:)")));
- (int8_t)byteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("byteValue(exactRequired:)")));
- (FlowBignumBigDecimal *)ceil __attribute__((swift_name("ceil()")));
- (int32_t)compareOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("compare(other:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (int32_t)compareToOther:(id)other __attribute__((swift_name("compareTo(other:)")));
- (FlowBignumBigDecimal *)doCopySignificand:(FlowBignumBigInteger *)significand exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("doCopy(significand:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)dec __attribute__((swift_name("dec()")));
- (FlowBignumBigDecimal *)divOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("div(other:)")));
- (FlowBignumBigDecimal *)divideOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("divide(other:)")));
- (FlowBignumBigDecimal *)divideOther:(FlowBignumBigDecimal *)other decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("divide(other:decimalMode:)")));
- (FlowKotlinPair<FlowBignumBigDecimal *, FlowBignumBigDecimal *> *)divideAndRemainderOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (FlowKotlinPair<FlowBignumBigDecimal *, FlowBignumBigDecimal *> *)divremOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("divrem(other:)")));
- (double)doubleValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("doubleValue(exactRequired:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (float)floatValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("floatValue(exactRequired:)")));
- (FlowBignumBigDecimal *)floor __attribute__((swift_name("floor()")));
- (id<FlowBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (FlowBignumBigDecimal *)getInstance __attribute__((swift_name("getInstance()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (FlowBignumBigDecimal *)inc __attribute__((swift_name("inc()")));
- (int32_t)intValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("intValue(exactRequired:)")));
- (BOOL)isWholeNumber __attribute__((swift_name("isWholeNumber()")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (int64_t)longValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("longValue(exactRequired:)")));
- (FlowBignumBigDecimal *)minusOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("minus(other:)")));
- (FlowBignumBigDecimal *)moveDecimalPointPlaces:(int32_t)places __attribute__((swift_name("moveDecimalPoint(places:)")));
- (FlowBignumBigDecimal *)moveDecimalPointPlaces_:(int64_t)places __attribute__((swift_name("moveDecimalPoint(places_:)")));
- (FlowBignumBigDecimal *)multiplyOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("multiply(other:)")));
- (FlowBignumBigDecimal *)multiplyOther:(FlowBignumBigDecimal *)other decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("multiply(other:decimalMode:)")));
- (FlowBignumBigDecimal *)negate __attribute__((swift_name("negate()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (FlowBignumBigDecimal *)plusOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("plus(other:)")));
- (FlowBignumBigDecimal *)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (FlowBignumBigDecimal *)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (FlowBignumBigDecimal *)remOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("rem(other:)")));
- (FlowBignumBigDecimal *)remainderOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("remainder(other:)")));
- (FlowBignumBigDecimal *)removeScale __attribute__((swift_name("removeScale()")));
- (FlowBignumBigDecimal *)roundSignificandDecimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("roundSignificand(decimalMode:)")));
- (FlowBignumBigDecimal *)roundToDigitPositionDigitPosition:(int64_t)digitPosition roundingMode:(FlowBignumRoundingMode *)roundingMode __attribute__((swift_name("roundToDigitPosition(digitPosition:roundingMode:)")));
- (FlowBignumBigDecimal *)roundToDigitPositionAfterDecimalPointDigitPosition:(int64_t)digitPosition roundingMode:(FlowBignumRoundingMode *)roundingMode __attribute__((swift_name("roundToDigitPositionAfterDecimalPoint(digitPosition:roundingMode:)")));
- (FlowBignumBigDecimal *)scaleScale:(int64_t)scale __attribute__((swift_name("scale(scale:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (int16_t)shortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("shortValue(exactRequired:)")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (FlowBignumBigDecimal *)subtractOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("subtract(other:)")));
- (FlowBignumBigDecimal *)subtractOther:(FlowBignumBigDecimal *)other decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("subtract(other:decimalMode:)")));
- (FlowBignumBigDecimal *)timesOther:(FlowBignumBigDecimal *)other __attribute__((swift_name("times(other:)")));
- (FlowBignumBigInteger *)toBigInteger __attribute__((swift_name("toBigInteger()")));
- (NSString *)toPlainString __attribute__((swift_name("toPlainString()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (NSString *)toStringExpanded __attribute__((swift_name("toStringExpanded()")));
- (uint8_t)ubyteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ubyteValue(exactRequired:)")));
- (uint32_t)uintValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("uintValue(exactRequired:)")));
- (uint64_t)ulongValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ulongValue(exactRequired:)")));
- (FlowBignumBigDecimal *)unaryMinus __attribute__((swift_name("unaryMinus()")));
- (uint16_t)ushortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ushortValue(exactRequired:)")));
- (NSString *)times:(int64_t)receiver char:(unichar)char_ __attribute__((swift_name("times(_:char:)")));
@property (readonly) FlowBignumDecimalMode * _Nullable decimalMode __attribute__((swift_name("decimalMode")));
@property (readonly) int64_t exponent __attribute__((swift_name("exponent")));
@property (readonly) int64_t precision __attribute__((swift_name("precision")));
@property (readonly) int64_t precisionLimit __attribute__((swift_name("precisionLimit")));
@property (readonly) FlowBignumRoundingMode *roundingMode __attribute__((swift_name("roundingMode")));
@property (readonly) int64_t scale __attribute__((swift_name("scale")));
@property (readonly) FlowBignumBigInteger *significand __attribute__((swift_name("significand")));
@property (readonly) BOOL usingScale __attribute__((swift_name("usingScale")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinPair")))
@interface FlowKotlinPair<__covariant A, __covariant B> : FlowBase
- (instancetype)initWithFirst:(A _Nullable)first second:(B _Nullable)second __attribute__((swift_name("init(first:second:)"))) __attribute__((objc_designated_initializer));
- (A _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (B _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKotlinPair<A, B> *)doCopyFirst:(A _Nullable)first second:(B _Nullable)second __attribute__((swift_name("doCopy(first:second:)")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@property (readonly) A _Nullable first __attribute__((swift_name("first")));
@property (readonly) B _Nullable second __attribute__((swift_name("second")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface FlowKotlinEnumCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement")))
@interface FlowKotlinx_serialization_jsonJsonElement : FlowBase
@property (class, readonly, getter=companion) FlowKotlinx_serialization_jsonJsonElementCompanion *companion __attribute__((swift_name("companion")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialFormat")))
@protocol FlowKotlinx_serialization_coreSerialFormat
@required
@property (readonly) FlowKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreStringFormat")))
@protocol FlowKotlinx_serialization_coreStringFormat <FlowKotlinx_serialization_coreSerialFormat>
@required
- (id _Nullable)decodeFromStringDeserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer string:(NSString *)string __attribute__((swift_name("decodeFromString(deserializer:string:)")));
- (NSString *)encodeToStringSerializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToString(serializer:value:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_jsonJson")))
@interface FlowKotlinx_serialization_jsonJson : FlowBase <FlowKotlinx_serialization_coreStringFormat>
@property (class, readonly, getter=companion) FlowKotlinx_serialization_jsonJsonDefault *companion __attribute__((swift_name("companion")));
- (id _Nullable)decodeFromJsonElementDeserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer element:(FlowKotlinx_serialization_jsonJsonElement *)element __attribute__((swift_name("decodeFromJsonElement(deserializer:element:)")));
- (id _Nullable)decodeFromStringDeserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer string:(NSString *)string __attribute__((swift_name("decodeFromString(deserializer:string:)")));
- (FlowKotlinx_serialization_jsonJsonElement *)encodeToJsonElementSerializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToJsonElement(serializer:value:)")));
- (NSString *)encodeToStringSerializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToString(serializer:value:)")));
- (FlowKotlinx_serialization_jsonJsonElement *)parseToJsonElementString:(NSString *)string __attribute__((swift_name("parseToJsonElement(string:)")));
@property (readonly) FlowKotlinx_serialization_jsonJsonConfiguration *configuration __attribute__((swift_name("configuration")));
@property (readonly) FlowKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface FlowKotlinUnit : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol FlowKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("KotlinByteIterator")))
@interface FlowKotlinByteIterator : FlowBase <FlowKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (FlowByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end;

__attribute__((swift_name("BignumBigNumberCreator")))
@protocol FlowBignumBigNumberCreator
@required
- (id _Nullable)fromBigIntegerBigInteger:(FlowBignumBigInteger *)bigInteger __attribute__((swift_name("fromBigInteger(bigInteger:)")));
- (id _Nullable)fromByteByte:(int8_t)byte __attribute__((swift_name("fromByte(byte:)")));
- (id _Nullable)fromIntInt:(int32_t)int_ __attribute__((swift_name("fromInt(int:)")));
- (id _Nullable)fromLongLong:(int64_t)long_ __attribute__((swift_name("fromLong(long:)")));
- (id _Nullable)fromShortShort:(int16_t)short_ __attribute__((swift_name("fromShort(short:)")));
- (id _Nullable)fromUByteUByte:(uint8_t)uByte __attribute__((swift_name("fromUByte(uByte:)")));
- (id _Nullable)fromUIntUInt:(uint32_t)uInt __attribute__((swift_name("fromUInt(uInt:)")));
- (id _Nullable)fromULongULong:(uint64_t)uLong __attribute__((swift_name("fromULong(uLong:)")));
- (id _Nullable)fromUShortUShort:(uint16_t)uShort __attribute__((swift_name("fromUShort(uShort:)")));
- (id _Nullable)parseStringString:(NSString *)string base:(int32_t)base __attribute__((swift_name("parseString(string:base:)")));
- (id _Nullable)tryFromDoubleDouble:(double)double_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromDouble(double:exactRequired:)")));
- (id _Nullable)tryFromFloatFloat:(float)float_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromFloat(float:exactRequired:)")));
@property (readonly) id _Nullable ONE __attribute__((swift_name("ONE")));
@property (readonly) id _Nullable TEN __attribute__((swift_name("TEN")));
@property (readonly) id _Nullable TWO __attribute__((swift_name("TWO")));
@property (readonly) id _Nullable ZERO __attribute__((swift_name("ZERO")));
@end;

__attribute__((swift_name("BignumBigNumberUtil")))
@protocol FlowBignumBigNumberUtil
@required
- (id _Nullable)maxFirst:(id _Nullable)first second:(id _Nullable)second __attribute__((swift_name("max(first:second:)")));
- (id _Nullable)minFirst:(id _Nullable)first second:(id _Nullable)second __attribute__((swift_name("min(first:second:)")));
@end;

__attribute__((swift_name("BignumByteArrayDeserializable")))
@protocol FlowBignumByteArrayDeserializable
@required
- (id<FlowBignumBigNumber>)fromByteArraySource:(FlowKotlinByteArray *)source sign:(FlowBignumSign *)sign __attribute__((swift_name("fromByteArray(source:sign:)")));
- (id<FlowBignumBigNumber>)fromUByteArraySource:(id)source sign:(FlowBignumSign *)sign __attribute__((swift_name("fromUByteArray(source:sign:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.Companion")))
@interface FlowBignumBigIntegerCompanion : FlowBase <FlowBignumBigNumberCreator, FlowBignumBigNumberUtil, FlowBignumByteArrayDeserializable>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBignumBigIntegerCompanion *shared __attribute__((swift_name("shared")));
- (FlowBignumBigInteger *)createFromWordArrayWordArray:(id)wordArray requestedSign:(FlowBignumSign *)requestedSign __attribute__((swift_name("createFromWordArray(wordArray:requestedSign:)")));
- (FlowBignumBigInteger *)fromBigIntegerBigInteger:(FlowBignumBigInteger *)bigInteger __attribute__((swift_name("fromBigInteger(bigInteger:)")));
- (FlowBignumBigInteger *)fromByteByte:(int8_t)byte __attribute__((swift_name("fromByte(byte:)")));
- (FlowBignumBigInteger *)fromByteArraySource:(FlowKotlinByteArray *)source sign:(FlowBignumSign *)sign __attribute__((swift_name("fromByteArray(source:sign:)")));
- (FlowBignumBigInteger *)fromIntInt:(int32_t)int_ __attribute__((swift_name("fromInt(int:)")));
- (FlowBignumBigInteger *)fromLongLong:(int64_t)long_ __attribute__((swift_name("fromLong(long:)")));
- (FlowBignumBigInteger *)fromShortShort:(int16_t)short_ __attribute__((swift_name("fromShort(short:)")));
- (FlowBignumBigInteger *)fromUByteUByte:(uint8_t)uByte __attribute__((swift_name("fromUByte(uByte:)")));
- (FlowBignumBigInteger *)fromUByteArraySource:(id)source sign:(FlowBignumSign *)sign __attribute__((swift_name("fromUByteArray(source:sign:)")));
- (FlowBignumBigInteger *)fromUIntUInt:(uint32_t)uInt __attribute__((swift_name("fromUInt(uInt:)")));
- (FlowBignumBigInteger *)fromULongULong:(uint64_t)uLong __attribute__((swift_name("fromULong(uLong:)")));
- (FlowBignumBigInteger *)fromUShortUShort:(uint16_t)uShort __attribute__((swift_name("fromUShort(uShort:)")));
- (FlowBignumBigInteger *)maxFirst:(FlowBignumBigInteger *)first second:(FlowBignumBigInteger *)second __attribute__((swift_name("max(first:second:)")));
- (FlowBignumBigInteger *)minFirst:(FlowBignumBigInteger *)first second:(FlowBignumBigInteger *)second __attribute__((swift_name("min(first:second:)")));
- (FlowBignumBigInteger *)parseStringString:(NSString *)string base:(int32_t)base __attribute__((swift_name("parseString(string:base:)")));
- (FlowBignumBigInteger *)tryFromDoubleDouble:(double)double_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromDouble(double:exactRequired:)")));
- (FlowBignumBigInteger *)tryFromFloatFloat:(float)float_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromFloat(float:exactRequired:)")));
@property (readonly) double LOG_10_OF_2 __attribute__((swift_name("LOG_10_OF_2")));
@property (readonly) FlowBignumBigInteger *ONE __attribute__((swift_name("ONE")));
@property (readonly) FlowBignumBigInteger *TEN __attribute__((swift_name("TEN")));
@property (readonly) FlowBignumBigInteger *TWO __attribute__((swift_name("TWO")));
@property (readonly) FlowBignumBigInteger *ZERO __attribute__((swift_name("ZERO")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.QuotientAndRemainder")))
@interface FlowBignumBigIntegerQuotientAndRemainder : FlowBase
- (instancetype)initWithQuotient:(FlowBignumBigInteger *)quotient remainder:(FlowBignumBigInteger *)remainder __attribute__((swift_name("init(quotient:remainder:)"))) __attribute__((objc_designated_initializer));
- (FlowBignumBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumBigInteger *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumBigIntegerQuotientAndRemainder *)doCopyQuotient:(FlowBignumBigInteger *)quotient remainder:(FlowBignumBigInteger *)remainder __attribute__((swift_name("doCopy(quotient:remainder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumBigInteger *quotient __attribute__((swift_name("quotient")));
@property (readonly) FlowBignumBigInteger *remainder __attribute__((swift_name("remainder")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumSign")))
@interface FlowBignumSign : FlowKotlinEnum<FlowBignumSign *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) FlowBignumSign *positive __attribute__((swift_name("positive")));
@property (class, readonly) FlowBignumSign *negative __attribute__((swift_name("negative")));
@property (class, readonly) FlowBignumSign *zero __attribute__((swift_name("zero")));
+ (FlowKotlinArray<FlowBignumSign *> *)values __attribute__((swift_name("values()")));
- (FlowBignumSign *)not __attribute__((swift_name("not()")));
- (int32_t)toInt __attribute__((swift_name("toInt()")));
@end;

__attribute__((swift_name("KotlinClosedRange")))
@protocol FlowKotlinClosedRange
@required
- (BOOL)containsValue:(id)value __attribute__((swift_name("contains(value:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
@property (readonly) id endInclusive __attribute__((swift_name("endInclusive")));
@property (readonly) id start __attribute__((swift_name("start")));
@end;

__attribute__((swift_name("KotlinIterable")))
@protocol FlowKotlinIterable
@required
- (id<FlowKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.BigIntegerRange")))
@interface FlowBignumBigIntegerBigIntegerRange : FlowBase <FlowKotlinClosedRange, FlowKotlinIterable>
- (instancetype)initWithStart:(FlowBignumBigInteger *)start endInclusive:(FlowBignumBigInteger *)endInclusive __attribute__((swift_name("init(start:endInclusive:)"))) __attribute__((objc_designated_initializer));
- (id<FlowKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@property (readonly) FlowBignumBigInteger *endInclusive __attribute__((swift_name("endInclusive")));
@property (readonly) FlowBignumBigInteger *start __attribute__((swift_name("start")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigInteger.SqareRootAndRemainder")))
@interface FlowBignumBigIntegerSqareRootAndRemainder : FlowBase
- (instancetype)initWithSquareRoot:(FlowBignumBigInteger *)squareRoot remainder:(FlowBignumBigInteger *)remainder __attribute__((swift_name("init(squareRoot:remainder:)"))) __attribute__((objc_designated_initializer));
- (FlowBignumBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumBigInteger *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumBigIntegerSqareRootAndRemainder *)doCopySquareRoot:(FlowBignumBigInteger *)squareRoot remainder:(FlowBignumBigInteger *)remainder __attribute__((swift_name("doCopy(squareRoot:remainder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumBigInteger *remainder __attribute__((swift_name("remainder")));
@property (readonly) FlowBignumBigInteger *squareRoot __attribute__((swift_name("squareRoot")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumModularBigInteger")))
@interface FlowBignumModularBigInteger : FlowBase <FlowBignumBigNumber, FlowBignumByteArraySerializable>
@property (class, readonly, getter=companion) FlowBignumModularBigIntegerCompanion *companion __attribute__((swift_name("companion")));
- (FlowBignumModularBigInteger *)abs __attribute__((swift_name("abs()")));
- (FlowBignumModularBigInteger *)addOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("add(other:)")));
- (int8_t)byteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("byteValue(exactRequired:)")));
- (int32_t)compareOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("compare(other:)")));
- (int32_t)compareToOther_:(id)other __attribute__((swift_name("compareTo(other_:)")));
- (FlowBignumModularBigInteger *)divideOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("divide(other:)")));
- (FlowKotlinPair<FlowBignumModularBigInteger *, FlowBignumModularBigInteger *> *)divideAndRemainderOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("divideAndRemainder(other:)")));
- (FlowBignumModularQuotientAndRemainder *)divremOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("divrem(other:)")));
- (double)doubleValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("doubleValue(exactRequired:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (float)floatValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("floatValue(exactRequired:)")));
- (id<FlowBignumBigNumberCreator>)getCreator __attribute__((swift_name("getCreator()")));
- (FlowBignumModularBigInteger *)getInstance __attribute__((swift_name("getInstance()")));
- (int32_t)intValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("intValue(exactRequired:)")));
- (FlowBignumModularBigInteger *)inverse __attribute__((swift_name("inverse()")));
- (BOOL)isZero __attribute__((swift_name("isZero()")));
- (int64_t)longValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("longValue(exactRequired:)")));
- (FlowBignumModularBigInteger *)multiplyOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("multiply(other:)")));
- (FlowBignumModularBigInteger *)negate __attribute__((swift_name("negate()")));
- (int64_t)numberOfDecimalDigits __attribute__((swift_name("numberOfDecimalDigits()")));
- (FlowBignumModularBigInteger *)powExponent__:(FlowBignumBigInteger *)exponent __attribute__((swift_name("pow(exponent__:)")));
- (FlowBignumModularBigInteger *)powExponent___:(FlowBignumModularBigInteger *)exponent __attribute__((swift_name("pow(exponent___:)")));
- (FlowBignumModularBigInteger *)powExponent:(int32_t)exponent __attribute__((swift_name("pow(exponent:)")));
- (FlowBignumModularBigInteger *)powExponent_:(int64_t)exponent __attribute__((swift_name("pow(exponent_:)")));
- (FlowBignumModularBigInteger *)remOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("rem(other:)")));
- (FlowBignumModularBigInteger *)remainderOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("remainder(other:)")));
- (void)secureOverwrite __attribute__((swift_name("secureOverwrite()")));
- (int16_t)shortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("shortValue(exactRequired:)")));
- (int32_t)signum __attribute__((swift_name("signum()")));
- (FlowBignumModularBigInteger *)subtractOther:(FlowBignumModularBigInteger *)other __attribute__((swift_name("subtract(other:)")));
- (FlowBignumBigInteger *)toBigInteger __attribute__((swift_name("toBigInteger()")));
- (FlowKotlinByteArray *)toByteArray __attribute__((swift_name("toByteArray()")));
- (NSString *)description __attribute__((swift_name("description()")));
- (NSString *)toStringBase:(int32_t)base __attribute__((swift_name("toString(base:)")));
- (NSString *)toStringWithModuloBase:(int32_t)base __attribute__((swift_name("toStringWithModulo(base:)")));
- (id)toUByteArray __attribute__((swift_name("toUByteArray()")));
- (uint8_t)ubyteValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ubyteValue(exactRequired:)")));
- (uint32_t)uintValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("uintValue(exactRequired:)")));
- (uint64_t)ulongValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ulongValue(exactRequired:)")));
- (FlowBignumModularBigInteger *)unaryMinus __attribute__((swift_name("unaryMinus()")));
- (uint16_t)ushortValueExactRequired:(BOOL)exactRequired __attribute__((swift_name("ushortValue(exactRequired:)")));
@property (readonly) FlowBignumBigInteger *modulus __attribute__((swift_name("modulus")));
@property (readonly) FlowBignumBigInteger *residue __attribute__((swift_name("residue")));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol FlowKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<FlowKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<FlowKotlinCoroutineContextElement> _Nullable)getKey:(id<FlowKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<FlowKotlinCoroutineContext>)minusKeyKey:(id<FlowKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<FlowKotlinCoroutineContext>)plusContext:(id<FlowKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngine")))
@protocol FlowKtor_client_coreHttpClientEngine <FlowKotlinx_coroutines_coreCoroutineScope, FlowKtor_ioCloseable>
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeData:(FlowKtor_client_coreHttpRequestData *)data completionHandler:(void (^)(FlowKtor_client_coreHttpResponseData * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(data:completionHandler:)")));
- (void)installClient:(FlowKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
@property (readonly) FlowKtor_client_coreHttpClientEngineConfig *config __attribute__((swift_name("config")));
@property (readonly) FlowKotlinx_coroutines_coreCoroutineDispatcher *dispatcher __attribute__((swift_name("dispatcher")));
@property (readonly) NSSet<id<FlowKtor_client_coreHttpClientEngineCapability>> *supportedCapabilities __attribute__((swift_name("supportedCapabilities")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngineConfig")))
@interface FlowKtor_client_coreHttpClientEngineConfig : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property BOOL pipelining __attribute__((swift_name("pipelining")));
@property FlowKtor_client_coreProxyConfig * _Nullable proxy __attribute__((swift_name("proxy")));
@property int32_t threadsCount __attribute__((swift_name("threadsCount")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientConfig")))
@interface FlowKtor_client_coreHttpClientConfig<T> : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (FlowKtor_client_coreHttpClientConfig<T> *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(void (^)(T))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(FlowKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installPlugin:(id<FlowKtor_client_coreHttpClientPlugin>)plugin configure:(void (^)(id))configure __attribute__((swift_name("install(plugin:configure:)")));
- (void)installKey:(NSString *)key block:(void (^)(FlowKtor_client_coreHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(FlowKtor_client_coreHttpClientConfig<T> *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL developmentMode __attribute__((swift_name("developmentMode")));
@property BOOL expectSuccess __attribute__((swift_name("expectSuccess")));
@property BOOL followRedirects __attribute__((swift_name("followRedirects")));
@property BOOL useDefaultTransformers __attribute__((swift_name("useDefaultTransformers")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientEngineCapability")))
@protocol FlowKtor_client_coreHttpClientEngineCapability
@required
@end;

__attribute__((swift_name("Ktor_utilsAttributes")))
@protocol FlowKtor_utilsAttributes
@required
- (id)computeIfAbsentKey:(FlowKtor_utilsAttributeKey<id> *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(FlowKtor_utilsAttributeKey<id> *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<FlowKtor_utilsAttributeKey<id> *> *allKeys __attribute__((swift_name("allKeys")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_eventsEvents")))
@interface FlowKtor_eventsEvents : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)raiseDefinition:(FlowKtor_eventsEventDefinition<id> *)definition value:(id _Nullable)value __attribute__((swift_name("raise(definition:value:)")));
- (id<FlowKotlinx_coroutines_coreDisposableHandle>)subscribeDefinition:(FlowKtor_eventsEventDefinition<id> *)definition handler:(void (^)(id _Nullable))handler __attribute__((swift_name("subscribe(definition:handler:)")));
- (void)unsubscribeDefinition:(FlowKtor_eventsEventDefinition<id> *)definition handler:(void (^)(id _Nullable))handler __attribute__((swift_name("unsubscribe(definition:handler:)")));
@end;

__attribute__((swift_name("Ktor_utilsPipeline")))
@interface FlowKtor_utilsPipeline<TSubject, TContext> : FlowBase
- (instancetype)initWithPhase:(FlowKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<FlowKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(FlowKotlinArray<FlowKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(FlowKtor_utilsPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeContext:(TContext)context subject:(TSubject)subject completionHandler:(void (^)(TSubject _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(context:subject:completionHandler:)")));
- (void)insertPhaseAfterReference:(FlowKtor_utilsPipelinePhase *)reference phase:(FlowKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(FlowKtor_utilsPipelinePhase *)reference phase:(FlowKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(FlowKtor_utilsPipelinePhase *)phase block:(id<FlowKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (NSArray<id<FlowKotlinSuspendFunction2>> *)interceptorsForPhasePhase:(FlowKtor_utilsPipelinePhase *)phase __attribute__((swift_name("interceptorsForPhase(phase:)")));
- (void)mergeFrom:(FlowKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("merge(from:)")));
- (void)mergePhasesFrom:(FlowKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("mergePhases(from:)")));
- (void)resetFromFrom:(FlowKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("resetFrom(from:)")));
@property (readonly) id<FlowKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@property (readonly, getter=isEmpty_) BOOL isEmpty __attribute__((swift_name("isEmpty")));
@property (readonly) NSArray<FlowKtor_utilsPipelinePhase *> *items __attribute__((swift_name("items")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline")))
@interface FlowKtor_client_coreHttpReceivePipeline : FlowKtor_utilsPipeline<FlowKtor_client_coreHttpResponse *, FlowKotlinUnit *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(FlowKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<FlowKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(FlowKotlinArray<FlowKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_client_coreHttpReceivePipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline")))
@interface FlowKtor_client_coreHttpRequestPipeline : FlowKtor_utilsPipeline<id, FlowKtor_client_coreHttpRequestBuilder *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(FlowKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<FlowKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(FlowKotlinArray<FlowKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_client_coreHttpRequestPipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline")))
@interface FlowKtor_client_coreHttpResponsePipeline : FlowKtor_utilsPipeline<FlowKtor_client_coreHttpResponseContainer *, FlowKtor_client_coreHttpClientCall *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(FlowKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<FlowKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(FlowKotlinArray<FlowKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_client_coreHttpResponsePipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline")))
@interface FlowKtor_client_coreHttpSendPipeline : FlowKtor_utilsPipeline<id, FlowKtor_client_coreHttpRequestBuilder *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(FlowKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<FlowKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(FlowKotlinArray<FlowKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_client_coreHttpSendPipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol FlowKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<FlowKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));
- (void)encodeNullableSerializableElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<FlowKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) FlowKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface FlowKotlinx_serialization_coreSerializersModule : FlowBase
- (void)dumpToCollector:(id<FlowKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));
- (id<FlowKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<FlowKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<FlowKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));
- (id<FlowKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<FlowKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));
- (id<FlowKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<FlowKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol FlowKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface FlowKotlinx_serialization_coreSerialKind : FlowBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol FlowKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<FlowKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<FlowKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<FlowKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) FlowKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface FlowKotlinNothing : FlowBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumBigDecimal.Companion")))
@interface FlowBignumBigDecimalCompanion : FlowBase <FlowBignumBigNumberCreator>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBignumBigDecimalCompanion *shared __attribute__((swift_name("shared")));
- (FlowBignumBigDecimal *)fromBigDecimalBigDecimal:(FlowBignumBigDecimal *)bigDecimal decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromBigDecimal(bigDecimal:decimalMode:)")));
- (FlowBignumBigDecimal *)fromBigIntegerBigInteger:(FlowBignumBigInteger *)bigInteger __attribute__((swift_name("fromBigInteger(bigInteger:)")));
- (FlowBignumBigDecimal *)fromBigIntegerBigInteger:(FlowBignumBigInteger *)bigInteger decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromBigInteger(bigInteger:decimalMode:)")));
- (FlowBignumBigDecimal *)fromBigIntegerWithExponentBigInteger:(FlowBignumBigInteger *)bigInteger exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromBigIntegerWithExponent(bigInteger:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)fromByteByte:(int8_t)byte __attribute__((swift_name("fromByte(byte:)")));
- (FlowBignumBigDecimal *)fromByteByte:(int8_t)byte decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromByte(byte:decimalMode:)")));
- (FlowBignumBigDecimal *)fromByteAsSignificandByte:(int8_t)byte decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromByteAsSignificand(byte:decimalMode:)")));
- (FlowBignumBigDecimal *)fromByteWithExponentByte:(int8_t)byte exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromByteWithExponent(byte:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)fromDoubleDouble:(double)double_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromDouble(double:decimalMode:)")));
- (FlowBignumBigDecimal *)fromFloatFloat:(float)float_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromFloat(float:decimalMode:)")));
- (FlowBignumBigDecimal *)fromIntInt:(int32_t)int_ __attribute__((swift_name("fromInt(int:)")));
- (FlowBignumBigDecimal *)fromIntInt:(int32_t)int_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromInt(int:decimalMode:)")));
- (FlowBignumBigDecimal *)fromIntAsSignificandInt:(int32_t)int_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromIntAsSignificand(int:decimalMode:)")));
- (FlowBignumBigDecimal *)fromIntWithExponentInt:(int32_t)int_ exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromIntWithExponent(int:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)fromLongLong:(int64_t)long_ __attribute__((swift_name("fromLong(long:)")));
- (FlowBignumBigDecimal *)fromLongLong:(int64_t)long_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromLong(long:decimalMode:)")));
- (FlowBignumBigDecimal *)fromLongAsSignificandLong:(int64_t)long_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromLongAsSignificand(long:decimalMode:)")));
- (FlowBignumBigDecimal *)fromLongWithExponentLong:(int64_t)long_ exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromLongWithExponent(long:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)fromShortShort:(int16_t)short_ __attribute__((swift_name("fromShort(short:)")));
- (FlowBignumBigDecimal *)fromShortShort:(int16_t)short_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromShort(short:decimalMode:)")));
- (FlowBignumBigDecimal *)fromShortAsSignificandShort:(int16_t)short_ decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromShortAsSignificand(short:decimalMode:)")));
- (FlowBignumBigDecimal *)fromShortWithExponentShort:(int16_t)short_ exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromShortWithExponent(short:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)fromUByteUByte:(uint8_t)uByte __attribute__((swift_name("fromUByte(uByte:)")));
- (FlowBignumBigDecimal *)fromUByteUByte:(uint8_t)uByte decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromUByte(uByte:decimalMode:)")));
- (FlowBignumBigDecimal *)fromUIntUInt:(uint32_t)uInt __attribute__((swift_name("fromUInt(uInt:)")));
- (FlowBignumBigDecimal *)fromUIntUInt:(uint32_t)uInt decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromUInt(uInt:decimalMode:)")));
- (FlowBignumBigDecimal *)fromULongULong:(uint64_t)uLong __attribute__((swift_name("fromULong(uLong:)")));
- (FlowBignumBigDecimal *)fromULongULong:(uint64_t)uLong decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromULong(uLong:decimalMode:)")));
- (FlowBignumBigDecimal *)fromUShortUShort:(uint16_t)uShort __attribute__((swift_name("fromUShort(uShort:)")));
- (FlowBignumBigDecimal *)fromUShortUShort:(uint16_t)uShort decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("fromUShort(uShort:decimalMode:)")));
- (FlowBignumBigDecimal *)handleZeroRoundingSignificand:(FlowBignumBigInteger *)significand exponent:(int64_t)exponent decimalMode:(FlowBignumDecimalMode *)decimalMode __attribute__((swift_name("handleZeroRounding(significand:exponent:decimalMode:)")));
- (FlowBignumBigDecimal *)parseStringString:(NSString *)string __attribute__((swift_name("parseString(string:)")));
- (FlowBignumBigDecimal *)parseStringString:(NSString *)string base:(int32_t)base __attribute__((swift_name("parseString(string:base:)")));
- (FlowBignumBigDecimal *)parseStringWithModeFloatingPointString:(NSString *)floatingPointString decimalMode:(FlowBignumDecimalMode * _Nullable)decimalMode __attribute__((swift_name("parseStringWithMode(floatingPointString:decimalMode:)")));
- (FlowBignumBigDecimal *)tryFromDoubleDouble:(double)double_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromDouble(double:exactRequired:)")));
- (FlowBignumBigDecimal *)tryFromFloatFloat:(float)float_ exactRequired:(BOOL)exactRequired __attribute__((swift_name("tryFromFloat(float:exactRequired:)")));
@property (readonly) FlowBignumBigDecimal *ONE __attribute__((swift_name("ONE")));
@property (readonly) FlowBignumBigDecimal *TEN __attribute__((swift_name("TEN")));
@property (readonly) FlowBignumBigDecimal *TWO __attribute__((swift_name("TWO")));
@property (readonly) FlowBignumBigDecimal *ZERO __attribute__((swift_name("ZERO")));
@property BOOL useToStringExpanded __attribute__((swift_name("useToStringExpanded")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumDecimalMode")))
@interface FlowBignumDecimalMode : FlowBase
- (instancetype)initWithDecimalPrecision:(int64_t)decimalPrecision roundingMode:(FlowBignumRoundingMode *)roundingMode scale:(int64_t)scale __attribute__((swift_name("init(decimalPrecision:roundingMode:scale:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowBignumDecimalModeCompanion *companion __attribute__((swift_name("companion")));
- (int64_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumRoundingMode *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (int64_t)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumDecimalMode *)doCopyDecimalPrecision:(int64_t)decimalPrecision roundingMode:(FlowBignumRoundingMode *)roundingMode scale:(int64_t)scale __attribute__((swift_name("doCopy(decimalPrecision:roundingMode:scale:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t decimalPrecision __attribute__((swift_name("decimalPrecision")));
@property (readonly) BOOL isPrecisionUnlimited __attribute__((swift_name("isPrecisionUnlimited")));
@property (readonly) FlowBignumRoundingMode *roundingMode __attribute__((swift_name("roundingMode")));
@property (readonly) int64_t scale __attribute__((swift_name("scale")));
@property (readonly) BOOL usingScale __attribute__((swift_name("usingScale")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumRoundingMode")))
@interface FlowBignumRoundingMode : FlowKotlinEnum<FlowBignumRoundingMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) FlowBignumRoundingMode *floor __attribute__((swift_name("floor")));
@property (class, readonly) FlowBignumRoundingMode *ceiling __attribute__((swift_name("ceiling")));
@property (class, readonly) FlowBignumRoundingMode *awayFromZero __attribute__((swift_name("awayFromZero")));
@property (class, readonly) FlowBignumRoundingMode *towardsZero __attribute__((swift_name("towardsZero")));
@property (class, readonly) FlowBignumRoundingMode *none __attribute__((swift_name("none")));
@property (class, readonly) FlowBignumRoundingMode *roundHalfAwayFromZero __attribute__((swift_name("roundHalfAwayFromZero")));
@property (class, readonly) FlowBignumRoundingMode *roundHalfTowardsZero __attribute__((swift_name("roundHalfTowardsZero")));
@property (class, readonly) FlowBignumRoundingMode *roundHalfCeiling __attribute__((swift_name("roundHalfCeiling")));
@property (class, readonly) FlowBignumRoundingMode *roundHalfFloor __attribute__((swift_name("roundHalfFloor")));
@property (class, readonly) FlowBignumRoundingMode *roundHalfToEven __attribute__((swift_name("roundHalfToEven")));
@property (class, readonly) FlowBignumRoundingMode *roundHalfToOdd __attribute__((swift_name("roundHalfToOdd")));
+ (FlowKotlinArray<FlowBignumRoundingMode *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement.Companion")))
@interface FlowKotlinx_serialization_jsonJsonElementCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKotlinx_serialization_jsonJsonElementCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJson.Default")))
@interface FlowKotlinx_serialization_jsonJsonDefault : FlowKotlinx_serialization_jsonJson
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)default_ __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKotlinx_serialization_jsonJsonDefault *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonConfiguration")))
@interface FlowKotlinx_serialization_jsonJsonConfiguration : FlowBase
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL allowSpecialFloatingPointValues __attribute__((swift_name("allowSpecialFloatingPointValues")));
@property (readonly) BOOL allowStructuredMapKeys __attribute__((swift_name("allowStructuredMapKeys")));
@property (readonly) NSString *classDiscriminator __attribute__((swift_name("classDiscriminator")));
@property (readonly) BOOL coerceInputValues __attribute__((swift_name("coerceInputValues")));
@property (readonly) BOOL encodeDefaults __attribute__((swift_name("encodeDefaults")));
@property (readonly) BOOL explicitNulls __attribute__((swift_name("explicitNulls")));
@property (readonly) BOOL ignoreUnknownKeys __attribute__((swift_name("ignoreUnknownKeys")));
@property (readonly) BOOL isLenient __attribute__((swift_name("isLenient")));
@property (readonly) BOOL prettyPrint __attribute__((swift_name("prettyPrint")));
@property (readonly) NSString *prettyPrintIndent __attribute__((swift_name("prettyPrintIndent")));
@property (readonly) BOOL useAlternativeNames __attribute__((swift_name("useAlternativeNames")));
@property (readonly) BOOL useArrayPolymorphism __attribute__((swift_name("useArrayPolymorphism")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumModularBigInteger.Companion")))
@interface FlowBignumModularBigIntegerCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBignumModularBigIntegerCompanion *shared __attribute__((swift_name("shared")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo:(FlowBignumBigInteger *)modulo __attribute__((swift_name("creatorForModulo(modulo:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo_:(int8_t)modulo __attribute__((swift_name("creatorForModulo(modulo_:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo__:(int32_t)modulo __attribute__((swift_name("creatorForModulo(modulo__:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo___:(int64_t)modulo __attribute__((swift_name("creatorForModulo(modulo___:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo____:(int16_t)modulo __attribute__((swift_name("creatorForModulo(modulo____:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo_____:(uint8_t)modulo __attribute__((swift_name("creatorForModulo(modulo_____:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo______:(uint32_t)modulo __attribute__((swift_name("creatorForModulo(modulo______:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo_______:(uint64_t)modulo __attribute__((swift_name("creatorForModulo(modulo_______:)")));
- (id<FlowBignumBigNumberCreator>)creatorForModuloModulo________:(uint16_t)modulo __attribute__((swift_name("creatorForModulo(modulo________:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumModularQuotientAndRemainder")))
@interface FlowBignumModularQuotientAndRemainder : FlowBase
- (instancetype)initWithQuotient:(FlowBignumModularBigInteger *)quotient remainder:(FlowBignumModularBigInteger *)remainder __attribute__((swift_name("init(quotient:remainder:)"))) __attribute__((objc_designated_initializer));
- (FlowBignumModularBigInteger *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumModularBigInteger *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowBignumModularQuotientAndRemainder *)doCopyQuotient:(FlowBignumModularBigInteger *)quotient remainder:(FlowBignumModularBigInteger *)remainder __attribute__((swift_name("doCopy(quotient:remainder:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowBignumModularBigInteger *quotient __attribute__((swift_name("quotient")));
@property (readonly) FlowBignumModularBigInteger *remainder __attribute__((swift_name("remainder")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol FlowKotlinCoroutineContextElement <FlowKotlinCoroutineContext>
@required
@property (readonly) id<FlowKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol FlowKotlinCoroutineContextKey
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestData")))
@interface FlowKtor_client_coreHttpRequestData : FlowBase
- (instancetype)initWithUrl:(FlowKtor_httpUrl *)url method:(FlowKtor_httpHttpMethod *)method headers:(id<FlowKtor_httpHeaders>)headers body:(FlowKtor_httpOutgoingContent *)body executionContext:(id<FlowKotlinx_coroutines_coreJob>)executionContext attributes:(id<FlowKtor_utilsAttributes>)attributes __attribute__((swift_name("init(url:method:headers:body:executionContext:attributes:)"))) __attribute__((objc_designated_initializer));
- (id _Nullable)getCapabilityOrNullKey:(id<FlowKtor_client_coreHttpClientEngineCapability>)key __attribute__((swift_name("getCapabilityOrNull(key:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<FlowKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) FlowKtor_httpOutgoingContent *body __attribute__((swift_name("body")));
@property (readonly) id<FlowKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) id<FlowKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) FlowKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) FlowKtor_httpUrl *url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseData")))
@interface FlowKtor_client_coreHttpResponseData : FlowBase
- (instancetype)initWithStatusCode:(FlowKtor_httpHttpStatusCode *)statusCode requestTime:(FlowKtor_utilsGMTDate *)requestTime headers:(id<FlowKtor_httpHeaders>)headers version:(FlowKtor_httpHttpProtocolVersion *)version body:(id)body callContext:(id<FlowKotlinCoroutineContext>)callContext __attribute__((swift_name("init(statusCode:requestTime:headers:version:body:callContext:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id body __attribute__((swift_name("body")));
@property (readonly) id<FlowKotlinCoroutineContext> callContext __attribute__((swift_name("callContext")));
@property (readonly) id<FlowKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) FlowKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) FlowKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) FlowKtor_httpHttpStatusCode *statusCode __attribute__((swift_name("statusCode")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface FlowKotlinAbstractCoroutineContextElement : FlowBase <FlowKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<FlowKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<FlowKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol FlowKotlinContinuationInterceptor <FlowKotlinCoroutineContextElement>
@required
- (id<FlowKotlinContinuation>)interceptContinuationContinuation:(id<FlowKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<FlowKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher")))
@interface FlowKotlinx_coroutines_coreCoroutineDispatcher : FlowKotlinAbstractCoroutineContextElement <FlowKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<FlowKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKotlinx_coroutines_coreCoroutineDispatcherKey *companion __attribute__((swift_name("companion")));
- (void)dispatchContext:(id<FlowKotlinCoroutineContext>)context block:(id<FlowKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<FlowKotlinCoroutineContext>)context block:(id<FlowKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (id<FlowKotlinContinuation>)interceptContinuationContinuation:(id<FlowKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (BOOL)isDispatchNeededContext:(id<FlowKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));
- (FlowKotlinx_coroutines_coreCoroutineDispatcher *)limitedParallelismParallelism:(int32_t)parallelism __attribute__((swift_name("limitedParallelism(parallelism:)")));
- (FlowKotlinx_coroutines_coreCoroutineDispatcher *)plusOther:(FlowKotlinx_coroutines_coreCoroutineDispatcher *)other __attribute__((swift_name("plus(other:)"))) __attribute__((unavailable("Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")));
- (void)releaseInterceptedContinuationContinuation:(id<FlowKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreProxyConfig")))
@interface FlowKtor_client_coreProxyConfig : FlowBase
- (instancetype)initWithUrl:(FlowKtor_httpUrl *)url __attribute__((swift_name("init(url:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKtor_httpUrl *url __attribute__((swift_name("url")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientPlugin")))
@protocol FlowKtor_client_coreHttpClientPlugin
@required
- (void)installPlugin:(id)plugin scope:(FlowKtor_client_coreHttpClient *)scope __attribute__((swift_name("install(plugin:scope:)")));
- (id)prepareBlock:(void (^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) FlowKtor_utilsAttributeKey<id> *key __attribute__((swift_name("key")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsAttributeKey")))
@interface FlowKtor_utilsAttributeKey<T> : FlowBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("Ktor_eventsEventDefinition")))
@interface FlowKtor_eventsEventDefinition<T> : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreDisposableHandle")))
@protocol FlowKotlinx_coroutines_coreDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsPipelinePhase")))
@interface FlowKtor_utilsPipelinePhase : FlowBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("KotlinFunction")))
@protocol FlowKotlinFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol FlowKotlinSuspendFunction2 <FlowKotlinFunction>
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 p2:(id _Nullable)p2 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:p2:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline.Phases")))
@interface FlowKtor_client_coreHttpReceivePipelinePhases : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_client_coreHttpReceivePipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_utilsPipelinePhase *After __attribute__((swift_name("After")));
@property (readonly) FlowKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) FlowKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@end;

__attribute__((swift_name("Ktor_httpHttpMessage")))
@protocol FlowKtor_httpHttpMessage
@required
@property (readonly) id<FlowKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpResponse")))
@interface FlowKtor_client_coreHttpResponse : FlowBase <FlowKtor_httpHttpMessage, FlowKotlinx_coroutines_coreCoroutineScope>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) id<FlowKtor_ioByteReadChannel> content __attribute__((swift_name("content")));
@property (readonly) FlowKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) FlowKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) FlowKtor_httpHttpStatusCode *status __attribute__((swift_name("status")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline.Phases")))
@interface FlowKtor_client_coreHttpRequestPipelinePhases : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_client_coreHttpRequestPipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) FlowKtor_utilsPipelinePhase *Render __attribute__((swift_name("Render")));
@property (readonly) FlowKtor_utilsPipelinePhase *Send __attribute__((swift_name("Send")));
@property (readonly) FlowKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@property (readonly) FlowKtor_utilsPipelinePhase *Transform __attribute__((swift_name("Transform")));
@end;

__attribute__((swift_name("Ktor_httpHttpMessageBuilder")))
@protocol FlowKtor_httpHttpMessageBuilder
@required
@property (readonly) FlowKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder")))
@interface FlowKtor_client_coreHttpRequestBuilder : FlowBase <FlowKtor_httpHttpMessageBuilder>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) FlowKtor_client_coreHttpRequestBuilderCompanion *companion __attribute__((swift_name("companion")));
- (FlowKtor_client_coreHttpRequestData *)build __attribute__((swift_name("build()")));
- (id _Nullable)getCapabilityOrNullKey:(id<FlowKtor_client_coreHttpClientEngineCapability>)key __attribute__((swift_name("getCapabilityOrNull(key:)")));
- (void)setAttributesBlock:(void (^)(id<FlowKtor_utilsAttributes>))block __attribute__((swift_name("setAttributes(block:)")));
- (void)setCapabilityKey:(id<FlowKtor_client_coreHttpClientEngineCapability>)key capability:(id)capability __attribute__((swift_name("setCapability(key:capability:)")));
- (FlowKtor_client_coreHttpRequestBuilder *)takeFromBuilder:(FlowKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFrom(builder:)")));
- (FlowKtor_client_coreHttpRequestBuilder *)takeFromWithExecutionContextBuilder:(FlowKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFromWithExecutionContext(builder:)")));
- (void)urlBlock:(void (^)(FlowKtor_httpURLBuilder *, FlowKtor_httpURLBuilder *))block __attribute__((swift_name("url(block:)")));
@property (readonly) id<FlowKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property id body __attribute__((swift_name("body")));
@property FlowKtor_utilsTypeInfo * _Nullable bodyType __attribute__((swift_name("bodyType")));
@property (readonly) id<FlowKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) FlowKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@property FlowKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) FlowKtor_httpURLBuilder *url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline.Phases")))
@interface FlowKtor_client_coreHttpResponsePipelinePhases : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_client_coreHttpResponsePipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_utilsPipelinePhase *After __attribute__((swift_name("After")));
@property (readonly) FlowKtor_utilsPipelinePhase *Parse __attribute__((swift_name("Parse")));
@property (readonly) FlowKtor_utilsPipelinePhase *Receive __attribute__((swift_name("Receive")));
@property (readonly) FlowKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@property (readonly) FlowKtor_utilsPipelinePhase *Transform __attribute__((swift_name("Transform")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseContainer")))
@interface FlowKtor_client_coreHttpResponseContainer : FlowBase
- (instancetype)initWithExpectedType:(FlowKtor_utilsTypeInfo *)expectedType response:(id)response __attribute__((swift_name("init(expectedType:response:)"))) __attribute__((objc_designated_initializer));
- (FlowKtor_utilsTypeInfo *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (id)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_client_coreHttpResponseContainer *)doCopyExpectedType:(FlowKtor_utilsTypeInfo *)expectedType response:(id)response __attribute__((swift_name("doCopy(expectedType:response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKtor_utilsTypeInfo *expectedType __attribute__((swift_name("expectedType")));
@property (readonly) id response __attribute__((swift_name("response")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpClientCall")))
@interface FlowKtor_client_coreHttpClientCall : FlowBase <FlowKotlinx_coroutines_coreCoroutineScope>
- (instancetype)initWithClient:(FlowKtor_client_coreHttpClient *)client requestData:(FlowKtor_client_coreHttpRequestData *)requestData responseData:(FlowKtor_client_coreHttpResponseData *)responseData __attribute__((swift_name("init(client:requestData:responseData:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithClient:(FlowKtor_client_coreHttpClient *)client __attribute__((swift_name("init(client:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_client_coreHttpClientCallCompanion *companion __attribute__((swift_name("companion")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)bodyInfo:(FlowKtor_utilsTypeInfo *)info completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("body(info:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)bodyNullableInfo:(FlowKtor_utilsTypeInfo *)info completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("bodyNullable(info:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getResponseContentWithCompletionHandler:(void (^)(id<FlowKtor_ioByteReadChannel> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getResponseContent(completionHandler:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL allowDoubleReceive __attribute__((swift_name("allowDoubleReceive")));
@property (readonly) id<FlowKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) FlowKtor_client_coreHttpClient *client __attribute__((swift_name("client")));
@property (readonly) id<FlowKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property id<FlowKtor_client_coreHttpRequest> request __attribute__((swift_name("request")));
@property FlowKtor_client_coreHttpResponse *response __attribute__((swift_name("response")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline.Phases")))
@interface FlowKtor_client_coreHttpSendPipelinePhases : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_client_coreHttpSendPipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) FlowKtor_utilsPipelinePhase *Engine __attribute__((swift_name("Engine")));
@property (readonly) FlowKtor_utilsPipelinePhase *Monitoring __attribute__((swift_name("Monitoring")));
@property (readonly) FlowKtor_utilsPipelinePhase *Receive __attribute__((swift_name("Receive")));
@property (readonly) FlowKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol FlowKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<FlowKotlinKClass>)kClass provider:(id<FlowKotlinx_serialization_coreKSerializer> (^)(NSArray<id<FlowKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<FlowKotlinKClass>)kClass serializer:(id<FlowKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<FlowKotlinKClass>)baseClass actualClass:(id<FlowKotlinKClass>)actualClass actualSerializer:(id<FlowKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<FlowKotlinKClass>)baseClass defaultDeserializerProvider:(id<FlowKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<FlowKotlinKClass>)baseClass defaultDeserializerProvider:(id<FlowKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<FlowKotlinKClass>)baseClass defaultSerializerProvider:(id<FlowKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol FlowKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol FlowKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol FlowKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol FlowKotlinKClass <FlowKotlinKDeclarationContainer, FlowKotlinKAnnotatedElement, FlowKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BignumDecimalMode.Companion")))
@interface FlowBignumDecimalModeCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowBignumDecimalModeCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowBignumDecimalMode *DEFAULT __attribute__((swift_name("DEFAULT")));
@property (readonly) FlowBignumDecimalMode *US_CURRENCY __attribute__((swift_name("US_CURRENCY")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl")))
@interface FlowKtor_httpUrl : FlowBase
@property (class, readonly, getter=companion) FlowKtor_httpUrlCompanion *companion __attribute__((swift_name("companion")));
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
@property (readonly) id<FlowKtor_httpParameters> parameters __attribute__((swift_name("parameters")));
@property (readonly) NSString * _Nullable password __attribute__((swift_name("password")));
@property (readonly) NSArray<NSString *> *pathSegments __attribute__((swift_name("pathSegments")));
@property (readonly) int32_t port __attribute__((swift_name("port")));
@property (readonly) FlowKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property (readonly) int32_t specifiedPort __attribute__((swift_name("specifiedPort")));
@property (readonly) BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property (readonly) NSString * _Nullable user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod")))
@interface FlowKtor_httpHttpMethod : FlowBase
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_httpHttpMethodCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_httpHttpMethod *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Ktor_utilsStringValues")))
@protocol FlowKtor_utilsStringValues
@required
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<FlowKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (void)forEachBody:(void (^)(NSString *, NSArray<NSString *> *))body __attribute__((swift_name("forEach(body:)")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end;

__attribute__((swift_name("Ktor_httpHeaders")))
@protocol FlowKtor_httpHeaders <FlowKtor_utilsStringValues>
@required
@end;

__attribute__((swift_name("Ktor_httpOutgoingContent")))
@interface FlowKtor_httpOutgoingContent : FlowBase
- (id _Nullable)getPropertyKey:(FlowKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getProperty(key:)")));
- (void)setPropertyKey:(FlowKtor_utilsAttributeKey<id> *)key value:(id _Nullable)value __attribute__((swift_name("setProperty(key:value:)")));
- (id<FlowKtor_httpHeaders> _Nullable)trailers __attribute__((swift_name("trailers()")));
@property (readonly) FlowLong * _Nullable contentLength __attribute__((swift_name("contentLength")));
@property (readonly) FlowKtor_httpContentType * _Nullable contentType __attribute__((swift_name("contentType")));
@property (readonly) id<FlowKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) FlowKtor_httpHttpStatusCode * _Nullable status __attribute__((swift_name("status")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreJob")))
@protocol FlowKotlinx_coroutines_coreJob <FlowKotlinCoroutineContextElement>
@required
- (id<FlowKotlinx_coroutines_coreChildHandle>)attachChildChild:(id<FlowKotlinx_coroutines_coreChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancelCause:(FlowKotlinCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (FlowKotlinCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<FlowKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(void (^)(FlowKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));
- (id<FlowKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionHandler:(void (^)(FlowKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)joinWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("join(completionHandler:)")));
- (id<FlowKotlinx_coroutines_coreJob>)plusOther_:(id<FlowKotlinx_coroutines_coreJob>)other __attribute__((swift_name("plus(other_:)"))) __attribute__((unavailable("Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")));
- (BOOL)start_ __attribute__((swift_name("start()")));
@property (readonly) id<FlowKotlinSequence> children __attribute__((swift_name("children")));
@property (readonly) BOOL isActive __attribute__((swift_name("isActive")));
@property (readonly) BOOL isCancelled __attribute__((swift_name("isCancelled")));
@property (readonly) BOOL isCompleted __attribute__((swift_name("isCompleted")));
@property (readonly) id<FlowKotlinx_coroutines_coreSelectClause0> onJoin __attribute__((swift_name("onJoin")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode")))
@interface FlowKtor_httpHttpStatusCode : FlowBase
- (instancetype)initWithValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("init(value:description:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_httpHttpStatusCodeCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_httpHttpStatusCode *)doCopyValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("doCopy(value:description:)")));
- (FlowKtor_httpHttpStatusCode *)descriptionValue:(NSString *)value __attribute__((swift_name("description(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@property (readonly) int32_t value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate")))
@interface FlowKtor_utilsGMTDate : FlowBase <FlowKotlinComparable>
@property (class, readonly, getter=companion) FlowKtor_utilsGMTDateCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(FlowKtor_utilsGMTDate *)other __attribute__((swift_name("compareTo(other:)")));
- (int32_t)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_utilsWeekDay *)component4 __attribute__((swift_name("component4()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component5 __attribute__((swift_name("component5()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component6 __attribute__((swift_name("component6()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_utilsMonth *)component7 __attribute__((swift_name("component7()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component8 __attribute__((swift_name("component8()"))) __attribute__((deprecated("use corresponding property instead")));
- (int64_t)component9 __attribute__((swift_name("component9()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_utilsGMTDate *)doCopySeconds:(int32_t)seconds minutes:(int32_t)minutes hours:(int32_t)hours dayOfWeek:(FlowKtor_utilsWeekDay *)dayOfWeek dayOfMonth:(int32_t)dayOfMonth dayOfYear:(int32_t)dayOfYear month:(FlowKtor_utilsMonth *)month year:(int32_t)year timestamp:(int64_t)timestamp __attribute__((swift_name("doCopy(seconds:minutes:hours:dayOfWeek:dayOfMonth:dayOfYear:month:year:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) FlowKtor_utilsWeekDay *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) int32_t hours __attribute__((swift_name("hours")));
@property (readonly) int32_t minutes __attribute__((swift_name("minutes")));
@property (readonly) FlowKtor_utilsMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t seconds __attribute__((swift_name("seconds")));
@property (readonly) int64_t timestamp __attribute__((swift_name("timestamp")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion")))
@interface FlowKtor_httpHttpProtocolVersion : FlowBase
- (instancetype)initWithName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("init(name:major:minor:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_httpHttpProtocolVersionCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_httpHttpProtocolVersion *)doCopyName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("doCopy(name:major:minor:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t major __attribute__((swift_name("major")));
@property (readonly) int32_t minor __attribute__((swift_name("minor")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("KotlinContinuation")))
@protocol FlowKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<FlowKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end;

__attribute__((swift_name("KotlinAbstractCoroutineContextKey")))
@interface FlowKotlinAbstractCoroutineContextKey<B, E> : FlowBase <FlowKotlinCoroutineContextKey>
- (instancetype)initWithBaseKey:(id<FlowKotlinCoroutineContextKey>)baseKey safeCast:(E _Nullable (^)(id<FlowKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher.Key")))
@interface FlowKotlinx_coroutines_coreCoroutineDispatcherKey : FlowKotlinAbstractCoroutineContextKey<id<FlowKotlinContinuationInterceptor>, FlowKotlinx_coroutines_coreCoroutineDispatcher *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithBaseKey:(id<FlowKotlinCoroutineContextKey>)baseKey safeCast:(id<FlowKotlinCoroutineContextElement> _Nullable (^)(id<FlowKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)key __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKotlinx_coroutines_coreCoroutineDispatcherKey *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreRunnable")))
@protocol FlowKotlinx_coroutines_coreRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end;

__attribute__((swift_name("Ktor_ioByteReadChannel")))
@protocol FlowKtor_ioByteReadChannel
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)awaitContentWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("awaitContent(completionHandler:)")));
- (BOOL)cancelCause_:(FlowKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)discardMax:(int64_t)max completionHandler:(void (^)(FlowLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("discard(max:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)peekToDestination:(FlowKtor_ioMemory *)destination destinationOffset:(int64_t)destinationOffset offset:(int64_t)offset min:(int64_t)min max:(int64_t)max completionHandler:(void (^)(FlowLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("peekTo(destination:destinationOffset:offset:min:max:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(FlowKtor_ioChunkBuffer *)dst completionHandler:(void (^)(FlowInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(FlowKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length completionHandler:(void (^)(FlowInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler:)")));
- (int32_t)readAvailableMin:(int32_t)min block:(void (^)(FlowKtor_ioBuffer *))block __attribute__((swift_name("readAvailable(min:block:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(void *)dst offset:(int32_t)offset length:(int32_t)length completionHandler_:(void (^)(FlowInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler_:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(void *)dst offset:(int64_t)offset length:(int64_t)length completionHandler__:(void (^)(FlowInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler__:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readBooleanWithCompletionHandler:(void (^)(FlowBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readBoolean(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readByteWithCompletionHandler:(void (^)(FlowByte * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readByte(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readDoubleWithCompletionHandler:(void (^)(FlowDouble * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readDouble(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFloatWithCompletionHandler:(void (^)(FlowFloat * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readFloat(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(FlowKtor_ioChunkBuffer *)dst n:(int32_t)n completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:n:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(FlowKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(void *)dst offset:(int32_t)offset length:(int32_t)length completionHandler_:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler_:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(void *)dst offset:(int64_t)offset length:(int64_t)length completionHandler__:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler__:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readIntWithCompletionHandler:(void (^)(FlowInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readInt(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readLongWithCompletionHandler:(void (^)(FlowLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readLong(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readPacketSize:(int32_t)size completionHandler:(void (^)(FlowKtor_ioByteReadPacket * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readPacket(size:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readRemainingLimit:(int64_t)limit completionHandler:(void (^)(FlowKtor_ioByteReadPacket * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readRemaining(limit:completionHandler:)")));
- (void)readSessionConsumer:(void (^)(id<FlowKtor_ioReadSession>))consumer __attribute__((swift_name("readSession(consumer:)"))) __attribute__((deprecated("Use read { } instead.")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readShortWithCompletionHandler:(void (^)(FlowShort * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readShort(completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readSuspendableSessionConsumer:(id<FlowKotlinSuspendFunction1>)consumer completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readSuspendableSession(consumer:completionHandler:)"))) __attribute__((deprecated("Use read { } instead.")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readUTF8LineLimit:(int32_t)limit completionHandler:(void (^)(NSString * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("readUTF8Line(limit:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)readUTF8LineToOut:(id<FlowKotlinAppendable>)out limit:(int32_t)limit completionHandler:(void (^)(FlowBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readUTF8LineTo(out:limit:completionHandler:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@property (readonly) FlowKotlinThrowable * _Nullable closedCause __attribute__((swift_name("closedCause")));
@property (readonly) BOOL isClosedForRead __attribute__((swift_name("isClosedForRead")));
@property (readonly) BOOL isClosedForWrite __attribute__((swift_name("isClosedForWrite")));
@property (readonly) int64_t totalBytesRead __attribute__((swift_name("totalBytesRead")));
@end;

__attribute__((swift_name("Ktor_utilsStringValuesBuilder")))
@protocol FlowKtor_utilsStringValuesBuilder
@required
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<FlowKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<FlowKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<FlowKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<FlowKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end;

__attribute__((swift_name("Ktor_utilsStringValuesBuilderImpl")))
@interface FlowKtor_utilsStringValuesBuilderImpl : FlowBase <FlowKtor_utilsStringValuesBuilder>
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer));
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<FlowKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<FlowKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<FlowKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<FlowKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));
- (void)validateNameName:(NSString *)name __attribute__((swift_name("validateName(name:)")));
- (void)validateValueValue:(NSString *)value __attribute__((swift_name("validateValue(value:)")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@property (readonly) FlowMutableDictionary<NSString *, NSMutableArray<NSString *> *> *values __attribute__((swift_name("values")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeadersBuilder")))
@interface FlowKtor_httpHeadersBuilder : FlowKtor_utilsStringValuesBuilderImpl
- (instancetype)initWithSize:(int32_t)size __attribute__((swift_name("init(size:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<FlowKtor_httpHeaders>)build __attribute__((swift_name("build()")));
- (void)validateNameName:(NSString *)name __attribute__((swift_name("validateName(name:)")));
- (void)validateValueValue:(NSString *)value __attribute__((swift_name("validateValue(value:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder.Companion")))
@interface FlowKtor_client_coreHttpRequestBuilderCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_client_coreHttpRequestBuilderCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder")))
@interface FlowKtor_httpURLBuilder : FlowBase
- (instancetype)initWithProtocol:(FlowKtor_httpURLProtocol *)protocol host:(NSString *)host port:(int32_t)port user:(NSString * _Nullable)user password:(NSString * _Nullable)password pathSegments:(NSArray<NSString *> *)pathSegments parameters:(id<FlowKtor_httpParameters>)parameters fragment:(NSString *)fragment trailingQuery:(BOOL)trailingQuery __attribute__((swift_name("init(protocol:host:port:user:password:pathSegments:parameters:fragment:trailingQuery:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_httpURLBuilderCompanion *companion __attribute__((swift_name("companion")));
- (FlowKtor_httpUrl *)build __attribute__((swift_name("build()")));
- (NSString *)buildString __attribute__((swift_name("buildString()")));
@property NSString *encodedFragment __attribute__((swift_name("encodedFragment")));
@property id<FlowKtor_httpParametersBuilder> encodedParameters __attribute__((swift_name("encodedParameters")));
@property NSString * _Nullable encodedPassword __attribute__((swift_name("encodedPassword")));
@property NSArray<NSString *> *encodedPathSegments __attribute__((swift_name("encodedPathSegments")));
@property NSString * _Nullable encodedUser __attribute__((swift_name("encodedUser")));
@property NSString *fragment __attribute__((swift_name("fragment")));
@property NSString *host __attribute__((swift_name("host")));
@property (readonly) id<FlowKtor_httpParametersBuilder> parameters __attribute__((swift_name("parameters")));
@property NSString * _Nullable password __attribute__((swift_name("password")));
@property NSArray<NSString *> *pathSegments __attribute__((swift_name("pathSegments")));
@property int32_t port __attribute__((swift_name("port")));
@property FlowKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property NSString * _Nullable user __attribute__((swift_name("user")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsTypeInfo")))
@interface FlowKtor_utilsTypeInfo : FlowBase
- (instancetype)initWithType:(id<FlowKotlinKClass>)type reifiedType:(id<FlowKotlinKType>)reifiedType kotlinType:(id<FlowKotlinKType> _Nullable)kotlinType __attribute__((swift_name("init(type:reifiedType:kotlinType:)"))) __attribute__((objc_designated_initializer));
- (id<FlowKotlinKClass>)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (id<FlowKotlinKType>)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (id<FlowKotlinKType> _Nullable)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_utilsTypeInfo *)doCopyType:(id<FlowKotlinKClass>)type reifiedType:(id<FlowKotlinKType>)reifiedType kotlinType:(id<FlowKotlinKType> _Nullable)kotlinType __attribute__((swift_name("doCopy(type:reifiedType:kotlinType:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<FlowKotlinKType> _Nullable kotlinType __attribute__((swift_name("kotlinType")));
@property (readonly) id<FlowKotlinKType> reifiedType __attribute__((swift_name("reifiedType")));
@property (readonly) id<FlowKotlinKClass> type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientCall.Companion")))
@interface FlowKtor_client_coreHttpClientCallCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_client_coreHttpClientCallCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_utilsAttributeKey<id> *CustomResponse __attribute__((swift_name("CustomResponse"))) __attribute__((unavailable("This is going to be removed. Please file a ticket with clarification why and what for do you need it.")));
@end;

__attribute__((swift_name("Ktor_client_coreHttpRequest")))
@protocol FlowKtor_client_coreHttpRequest <FlowKtor_httpHttpMessage, FlowKotlinx_coroutines_coreCoroutineScope>
@required
@property (readonly) id<FlowKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) FlowKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) FlowKtor_httpOutgoingContent *content __attribute__((swift_name("content")));
@property (readonly) FlowKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) FlowKtor_httpUrl *url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl.Companion")))
@interface FlowKtor_httpUrlCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpUrlCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Ktor_httpParameters")))
@protocol FlowKtor_httpParameters <FlowKtor_utilsStringValues>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol")))
@interface FlowKtor_httpURLProtocol : FlowBase
- (instancetype)initWithName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("init(name:defaultPort:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_httpURLProtocolCompanion *companion __attribute__((swift_name("companion")));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (int32_t)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_httpURLProtocol *)doCopyName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("doCopy(name:defaultPort:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t defaultPort __attribute__((swift_name("defaultPort")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod.Companion")))
@interface FlowKtor_httpHttpMethodCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpHttpMethodCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_httpHttpMethod *)parseMethod:(NSString *)method __attribute__((swift_name("parse(method:)")));
@property (readonly) NSArray<FlowKtor_httpHttpMethod *> *DefaultMethods __attribute__((swift_name("DefaultMethods")));
@property (readonly) FlowKtor_httpHttpMethod *Delete __attribute__((swift_name("Delete")));
@property (readonly) FlowKtor_httpHttpMethod *Get __attribute__((swift_name("Get")));
@property (readonly) FlowKtor_httpHttpMethod *Head __attribute__((swift_name("Head")));
@property (readonly) FlowKtor_httpHttpMethod *Options __attribute__((swift_name("Options")));
@property (readonly) FlowKtor_httpHttpMethod *Patch __attribute__((swift_name("Patch")));
@property (readonly) FlowKtor_httpHttpMethod *Post __attribute__((swift_name("Post")));
@property (readonly) FlowKtor_httpHttpMethod *Put __attribute__((swift_name("Put")));
@end;

__attribute__((swift_name("KotlinMapEntry")))
@protocol FlowKotlinMapEntry
@required
@property (readonly) id _Nullable key __attribute__((swift_name("key")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((swift_name("Ktor_httpHeaderValueWithParameters")))
@interface FlowKtor_httpHeaderValueWithParameters : FlowBase
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<FlowKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_httpHeaderValueWithParametersCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)parameterName:(NSString *)name __attribute__((swift_name("parameter(name:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *content __attribute__((swift_name("content")));
@property (readonly) NSArray<FlowKtor_httpHeaderValueParam *> *parameters __attribute__((swift_name("parameters")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType")))
@interface FlowKtor_httpContentType : FlowKtor_httpHeaderValueWithParameters
- (instancetype)initWithContentType:(NSString *)contentType contentSubtype:(NSString *)contentSubtype parameters:(NSArray<FlowKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(contentType:contentSubtype:parameters:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<FlowKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_httpContentTypeCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)matchPattern:(FlowKtor_httpContentType *)pattern __attribute__((swift_name("match(pattern:)")));
- (BOOL)matchPattern_:(NSString *)pattern __attribute__((swift_name("match(pattern_:)")));
- (FlowKtor_httpContentType *)withParameterName:(NSString *)name value:(NSString *)value __attribute__((swift_name("withParameter(name:value:)")));
- (FlowKtor_httpContentType *)withoutParameters __attribute__((swift_name("withoutParameters()")));
@property (readonly) NSString *contentSubtype __attribute__((swift_name("contentSubtype")));
@property (readonly) NSString *contentType __attribute__((swift_name("contentType")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChildHandle")))
@protocol FlowKotlinx_coroutines_coreChildHandle <FlowKotlinx_coroutines_coreDisposableHandle>
@required
- (BOOL)childCancelledCause:(FlowKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@property (readonly) id<FlowKotlinx_coroutines_coreJob> _Nullable parent __attribute__((swift_name("parent")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreChildJob")))
@protocol FlowKotlinx_coroutines_coreChildJob <FlowKotlinx_coroutines_coreJob>
@required
- (void)parentCancelledParentJob:(id<FlowKotlinx_coroutines_coreParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
@end;

__attribute__((swift_name("KotlinSequence")))
@protocol FlowKotlinSequence
@required
- (id<FlowKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause0")))
@protocol FlowKotlinx_coroutines_coreSelectClause0
@required
- (void)registerSelectClause0Select:(id<FlowKotlinx_coroutines_coreSelectInstance>)select block:(id<FlowKotlinSuspendFunction0>)block __attribute__((swift_name("registerSelectClause0(select:block:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode.Companion")))
@interface FlowKtor_httpHttpStatusCodeCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpHttpStatusCodeCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_httpHttpStatusCode *)fromValueValue:(int32_t)value __attribute__((swift_name("fromValue(value:)")));
@property (readonly) FlowKtor_httpHttpStatusCode *Accepted __attribute__((swift_name("Accepted")));
@property (readonly) FlowKtor_httpHttpStatusCode *BadGateway __attribute__((swift_name("BadGateway")));
@property (readonly) FlowKtor_httpHttpStatusCode *BadRequest __attribute__((swift_name("BadRequest")));
@property (readonly) FlowKtor_httpHttpStatusCode *Conflict __attribute__((swift_name("Conflict")));
@property (readonly) FlowKtor_httpHttpStatusCode *Continue __attribute__((swift_name("Continue")));
@property (readonly) FlowKtor_httpHttpStatusCode *Created __attribute__((swift_name("Created")));
@property (readonly) FlowKtor_httpHttpStatusCode *ExpectationFailed __attribute__((swift_name("ExpectationFailed")));
@property (readonly) FlowKtor_httpHttpStatusCode *FailedDependency __attribute__((swift_name("FailedDependency")));
@property (readonly) FlowKtor_httpHttpStatusCode *Forbidden __attribute__((swift_name("Forbidden")));
@property (readonly) FlowKtor_httpHttpStatusCode *Found __attribute__((swift_name("Found")));
@property (readonly) FlowKtor_httpHttpStatusCode *GatewayTimeout __attribute__((swift_name("GatewayTimeout")));
@property (readonly) FlowKtor_httpHttpStatusCode *Gone __attribute__((swift_name("Gone")));
@property (readonly) FlowKtor_httpHttpStatusCode *InsufficientStorage __attribute__((swift_name("InsufficientStorage")));
@property (readonly) FlowKtor_httpHttpStatusCode *InternalServerError __attribute__((swift_name("InternalServerError")));
@property (readonly) FlowKtor_httpHttpStatusCode *LengthRequired __attribute__((swift_name("LengthRequired")));
@property (readonly) FlowKtor_httpHttpStatusCode *Locked __attribute__((swift_name("Locked")));
@property (readonly) FlowKtor_httpHttpStatusCode *MethodNotAllowed __attribute__((swift_name("MethodNotAllowed")));
@property (readonly) FlowKtor_httpHttpStatusCode *MovedPermanently __attribute__((swift_name("MovedPermanently")));
@property (readonly) FlowKtor_httpHttpStatusCode *MultiStatus __attribute__((swift_name("MultiStatus")));
@property (readonly) FlowKtor_httpHttpStatusCode *MultipleChoices __attribute__((swift_name("MultipleChoices")));
@property (readonly) FlowKtor_httpHttpStatusCode *NoContent __attribute__((swift_name("NoContent")));
@property (readonly) FlowKtor_httpHttpStatusCode *NonAuthoritativeInformation __attribute__((swift_name("NonAuthoritativeInformation")));
@property (readonly) FlowKtor_httpHttpStatusCode *NotAcceptable __attribute__((swift_name("NotAcceptable")));
@property (readonly) FlowKtor_httpHttpStatusCode *NotFound __attribute__((swift_name("NotFound")));
@property (readonly) FlowKtor_httpHttpStatusCode *NotImplemented __attribute__((swift_name("NotImplemented")));
@property (readonly) FlowKtor_httpHttpStatusCode *NotModified __attribute__((swift_name("NotModified")));
@property (readonly) FlowKtor_httpHttpStatusCode *OK __attribute__((swift_name("OK")));
@property (readonly) FlowKtor_httpHttpStatusCode *PartialContent __attribute__((swift_name("PartialContent")));
@property (readonly) FlowKtor_httpHttpStatusCode *PayloadTooLarge __attribute__((swift_name("PayloadTooLarge")));
@property (readonly) FlowKtor_httpHttpStatusCode *PaymentRequired __attribute__((swift_name("PaymentRequired")));
@property (readonly) FlowKtor_httpHttpStatusCode *PermanentRedirect __attribute__((swift_name("PermanentRedirect")));
@property (readonly) FlowKtor_httpHttpStatusCode *PreconditionFailed __attribute__((swift_name("PreconditionFailed")));
@property (readonly) FlowKtor_httpHttpStatusCode *Processing __attribute__((swift_name("Processing")));
@property (readonly) FlowKtor_httpHttpStatusCode *ProxyAuthenticationRequired __attribute__((swift_name("ProxyAuthenticationRequired")));
@property (readonly) FlowKtor_httpHttpStatusCode *RequestHeaderFieldTooLarge __attribute__((swift_name("RequestHeaderFieldTooLarge")));
@property (readonly) FlowKtor_httpHttpStatusCode *RequestTimeout __attribute__((swift_name("RequestTimeout")));
@property (readonly) FlowKtor_httpHttpStatusCode *RequestURITooLong __attribute__((swift_name("RequestURITooLong")));
@property (readonly) FlowKtor_httpHttpStatusCode *RequestedRangeNotSatisfiable __attribute__((swift_name("RequestedRangeNotSatisfiable")));
@property (readonly) FlowKtor_httpHttpStatusCode *ResetContent __attribute__((swift_name("ResetContent")));
@property (readonly) FlowKtor_httpHttpStatusCode *SeeOther __attribute__((swift_name("SeeOther")));
@property (readonly) FlowKtor_httpHttpStatusCode *ServiceUnavailable __attribute__((swift_name("ServiceUnavailable")));
@property (readonly) FlowKtor_httpHttpStatusCode *SwitchProxy __attribute__((swift_name("SwitchProxy")));
@property (readonly) FlowKtor_httpHttpStatusCode *SwitchingProtocols __attribute__((swift_name("SwitchingProtocols")));
@property (readonly) FlowKtor_httpHttpStatusCode *TemporaryRedirect __attribute__((swift_name("TemporaryRedirect")));
@property (readonly) FlowKtor_httpHttpStatusCode *TooManyRequests __attribute__((swift_name("TooManyRequests")));
@property (readonly) FlowKtor_httpHttpStatusCode *Unauthorized __attribute__((swift_name("Unauthorized")));
@property (readonly) FlowKtor_httpHttpStatusCode *UnprocessableEntity __attribute__((swift_name("UnprocessableEntity")));
@property (readonly) FlowKtor_httpHttpStatusCode *UnsupportedMediaType __attribute__((swift_name("UnsupportedMediaType")));
@property (readonly) FlowKtor_httpHttpStatusCode *UpgradeRequired __attribute__((swift_name("UpgradeRequired")));
@property (readonly) FlowKtor_httpHttpStatusCode *UseProxy __attribute__((swift_name("UseProxy")));
@property (readonly) FlowKtor_httpHttpStatusCode *VariantAlsoNegotiates __attribute__((swift_name("VariantAlsoNegotiates")));
@property (readonly) FlowKtor_httpHttpStatusCode *VersionNotSupported __attribute__((swift_name("VersionNotSupported")));
@property (readonly) NSArray<FlowKtor_httpHttpStatusCode *> *allStatusCodes __attribute__((swift_name("allStatusCodes")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate.Companion")))
@interface FlowKtor_utilsGMTDateCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_utilsGMTDateCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_utilsGMTDate *START __attribute__((swift_name("START")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay")))
@interface FlowKtor_utilsWeekDay : FlowKotlinEnum<FlowKtor_utilsWeekDay *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_utilsWeekDayCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowKtor_utilsWeekDay *monday __attribute__((swift_name("monday")));
@property (class, readonly) FlowKtor_utilsWeekDay *tuesday __attribute__((swift_name("tuesday")));
@property (class, readonly) FlowKtor_utilsWeekDay *wednesday __attribute__((swift_name("wednesday")));
@property (class, readonly) FlowKtor_utilsWeekDay *thursday __attribute__((swift_name("thursday")));
@property (class, readonly) FlowKtor_utilsWeekDay *friday __attribute__((swift_name("friday")));
@property (class, readonly) FlowKtor_utilsWeekDay *saturday __attribute__((swift_name("saturday")));
@property (class, readonly) FlowKtor_utilsWeekDay *sunday __attribute__((swift_name("sunday")));
+ (FlowKotlinArray<FlowKtor_utilsWeekDay *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth")))
@interface FlowKtor_utilsMonth : FlowKotlinEnum<FlowKtor_utilsMonth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_utilsMonthCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) FlowKtor_utilsMonth *january __attribute__((swift_name("january")));
@property (class, readonly) FlowKtor_utilsMonth *february __attribute__((swift_name("february")));
@property (class, readonly) FlowKtor_utilsMonth *march __attribute__((swift_name("march")));
@property (class, readonly) FlowKtor_utilsMonth *april __attribute__((swift_name("april")));
@property (class, readonly) FlowKtor_utilsMonth *may __attribute__((swift_name("may")));
@property (class, readonly) FlowKtor_utilsMonth *june __attribute__((swift_name("june")));
@property (class, readonly) FlowKtor_utilsMonth *july __attribute__((swift_name("july")));
@property (class, readonly) FlowKtor_utilsMonth *august __attribute__((swift_name("august")));
@property (class, readonly) FlowKtor_utilsMonth *september __attribute__((swift_name("september")));
@property (class, readonly) FlowKtor_utilsMonth *october __attribute__((swift_name("october")));
@property (class, readonly) FlowKtor_utilsMonth *november __attribute__((swift_name("november")));
@property (class, readonly) FlowKtor_utilsMonth *december __attribute__((swift_name("december")));
+ (FlowKotlinArray<FlowKtor_utilsMonth *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion.Companion")))
@interface FlowKtor_httpHttpProtocolVersionCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpHttpProtocolVersionCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_httpHttpProtocolVersion *)fromValueName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("fromValue(name:major:minor:)")));
- (FlowKtor_httpHttpProtocolVersion *)parseValue:(id)value __attribute__((swift_name("parse(value:)")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *HTTP_1_0 __attribute__((swift_name("HTTP_1_0")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *HTTP_1_1 __attribute__((swift_name("HTTP_1_1")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *HTTP_2_0 __attribute__((swift_name("HTTP_2_0")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *QUIC __attribute__((swift_name("QUIC")));
@property (readonly) FlowKtor_httpHttpProtocolVersion *SPDY_3 __attribute__((swift_name("SPDY_3")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioMemory")))
@interface FlowKtor_ioMemory : FlowBase
- (instancetype)initWithPointer:(void *)pointer size:(int64_t)size __attribute__((swift_name("init(pointer:size:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_ioMemoryCompanion *companion __attribute__((swift_name("companion")));
- (void)doCopyToDestination:(FlowKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length destinationOffset:(int32_t)destinationOffset __attribute__((swift_name("doCopyTo(destination:offset:length:destinationOffset:)")));
- (void)doCopyToDestination:(FlowKtor_ioMemory *)destination offset:(int64_t)offset length:(int64_t)length destinationOffset_:(int64_t)destinationOffset __attribute__((swift_name("doCopyTo(destination:offset:length:destinationOffset_:)")));
- (int8_t)loadAtIndex:(int32_t)index __attribute__((swift_name("loadAt(index:)")));
- (int8_t)loadAtIndex_:(int64_t)index __attribute__((swift_name("loadAt(index_:)")));
- (FlowKtor_ioMemory *)sliceOffset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("slice(offset:length:)")));
- (FlowKtor_ioMemory *)sliceOffset:(int64_t)offset length_:(int64_t)length __attribute__((swift_name("slice(offset:length_:)")));
- (void)storeAtIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("storeAt(index:value:)")));
- (void)storeAtIndex:(int64_t)index value_:(int8_t)value __attribute__((swift_name("storeAt(index:value_:)")));
@property (readonly) void *pointer __attribute__((swift_name("pointer")));
@property (readonly) int64_t size __attribute__((swift_name("size")));
@property (readonly) int32_t size32 __attribute__((swift_name("size32")));
@end;

__attribute__((swift_name("Ktor_ioBuffer")))
@interface FlowKtor_ioBuffer : FlowBase
- (instancetype)initWithMemory:(FlowKtor_ioMemory *)memory __attribute__((swift_name("init(memory:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_ioBufferCompanion *companion __attribute__((swift_name("companion")));
- (void)commitWrittenCount:(int32_t)count __attribute__((swift_name("commitWritten(count:)")));
- (void)discardExactCount:(int32_t)count __attribute__((swift_name("discardExact(count:)")));
- (FlowKtor_ioBuffer *)duplicate __attribute__((swift_name("duplicate()")));
- (void)duplicateToCopy:(FlowKtor_ioBuffer *)copy __attribute__((swift_name("duplicateTo(copy:)")));
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
@property (readonly) FlowKtor_ioMemory *memory __attribute__((swift_name("memory")));
@property (readonly) int32_t readPosition __attribute__((swift_name("readPosition")));
@property (readonly) int32_t readRemaining __attribute__((swift_name("readRemaining")));
@property (readonly) int32_t startGap __attribute__((swift_name("startGap")));
@property (readonly) int32_t writePosition __attribute__((swift_name("writePosition")));
@property (readonly) int32_t writeRemaining __attribute__((swift_name("writeRemaining")));
@end;

__attribute__((swift_name("Ktor_ioChunkBuffer")))
@interface FlowKtor_ioChunkBuffer : FlowKtor_ioBuffer
- (instancetype)initWithMemory:(FlowKtor_ioMemory *)memory origin:(FlowKtor_ioChunkBuffer * _Nullable)origin parentPool:(id<FlowKtor_ioObjectPool> _Nullable)parentPool __attribute__((swift_name("init(memory:origin:parentPool:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMemory:(FlowKtor_ioMemory *)memory __attribute__((swift_name("init(memory:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_ioChunkBufferCompanion *companion __attribute__((swift_name("companion")));
- (FlowKtor_ioChunkBuffer * _Nullable)cleanNext __attribute__((swift_name("cleanNext()")));
- (FlowKtor_ioChunkBuffer *)duplicate __attribute__((swift_name("duplicate()")));
- (void)releasePool:(id<FlowKtor_ioObjectPool>)pool __attribute__((swift_name("release(pool:)")));
- (void)reset __attribute__((swift_name("reset()")));
@property (getter=next_) FlowKtor_ioChunkBuffer * _Nullable next __attribute__((swift_name("next")));
@property (readonly) FlowKtor_ioChunkBuffer * _Nullable origin __attribute__((swift_name("origin")));
@property (readonly) int32_t referenceCount __attribute__((swift_name("referenceCount")));
@end;

__attribute__((swift_name("Ktor_ioInput")))
@interface FlowKtor_ioInput : FlowBase <FlowKtor_ioCloseable>
- (instancetype)initWithHead:(FlowKtor_ioChunkBuffer *)head remaining:(int64_t)remaining pool:(id<FlowKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:remaining:pool:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKtor_ioInputCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)canRead __attribute__((swift_name("canRead()")));
- (void)close __attribute__((swift_name("close()")));
- (void)closeSource __attribute__((swift_name("closeSource()")));
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (int64_t)discardN_:(int64_t)n __attribute__((swift_name("discard(n_:)")));
- (void)discardExactN:(int32_t)n __attribute__((swift_name("discardExact(n:)")));
- (FlowKtor_ioChunkBuffer * _Nullable)fill __attribute__((swift_name("fill()")));
- (int32_t)fillDestination:(FlowKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("fill(destination:offset:length:)")));
- (BOOL)hasBytesN:(int32_t)n __attribute__((swift_name("hasBytes(n:)")));
- (void)markNoMoreChunksAvailable __attribute__((swift_name("markNoMoreChunksAvailable()")));
- (int64_t)peekToDestination:(FlowKtor_ioMemory *)destination destinationOffset:(int64_t)destinationOffset offset:(int64_t)offset min:(int64_t)min max:(int64_t)max __attribute__((swift_name("peekTo(destination:destinationOffset:offset:min:max:)")));
- (int32_t)peekToBuffer:(FlowKtor_ioChunkBuffer *)buffer __attribute__((swift_name("peekTo(buffer:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (NSString *)readTextMin:(int32_t)min max:(int32_t)max __attribute__((swift_name("readText(min:max:)")));
- (int32_t)readTextOut:(id<FlowKotlinAppendable>)out min:(int32_t)min max:(int32_t)max __attribute__((swift_name("readText(out:min:max:)")));
- (NSString *)readTextExactExactCharacters:(int32_t)exactCharacters __attribute__((swift_name("readTextExact(exactCharacters:)")));
- (void)readTextExactOut:(id<FlowKotlinAppendable>)out exactCharacters:(int32_t)exactCharacters __attribute__((swift_name("readTextExact(out:exactCharacters:)")));
- (void)release_ __attribute__((swift_name("release()")));
- (int32_t)tryPeek __attribute__((swift_name("tryPeek()")));
@property (readonly) BOOL endOfInput __attribute__((swift_name("endOfInput")));
@property (readonly) id<FlowKtor_ioObjectPool> pool __attribute__((swift_name("pool")));
@property (readonly) int64_t remaining __attribute__((swift_name("remaining")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioByteReadPacket")))
@interface FlowKtor_ioByteReadPacket : FlowKtor_ioInput
- (instancetype)initWithHead:(FlowKtor_ioChunkBuffer *)head pool:(id<FlowKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:pool:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithHead:(FlowKtor_ioChunkBuffer *)head remaining:(int64_t)remaining pool:(id<FlowKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:remaining:pool:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) FlowKtor_ioByteReadPacketCompanion *companion __attribute__((swift_name("companion")));
- (void)closeSource __attribute__((swift_name("closeSource()")));
- (FlowKtor_ioByteReadPacket *)doCopy __attribute__((swift_name("doCopy()")));
- (FlowKtor_ioChunkBuffer * _Nullable)fill __attribute__((swift_name("fill()")));
- (int32_t)fillDestination:(FlowKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("fill(destination:offset:length:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Ktor_ioReadSession")))
@protocol FlowKtor_ioReadSession
@required
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (FlowKtor_ioChunkBuffer * _Nullable)requestAtLeast:(int32_t)atLeast __attribute__((swift_name("request(atLeast:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@end;

__attribute__((swift_name("KotlinSuspendFunction1")))
@protocol FlowKotlinSuspendFunction1 <FlowKotlinFunction>
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:completionHandler:)")));
@end;

__attribute__((swift_name("KotlinAppendable")))
@protocol FlowKotlinAppendable
@required
- (id<FlowKotlinAppendable>)appendValue:(unichar)value __attribute__((swift_name("append(value:)")));
- (id<FlowKotlinAppendable>)appendValue_:(id _Nullable)value __attribute__((swift_name("append(value_:)")));
- (id<FlowKotlinAppendable>)appendValue:(id _Nullable)value startIndex:(int32_t)startIndex endIndex:(int32_t)endIndex __attribute__((swift_name("append(value:startIndex:endIndex:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder.Companion")))
@interface FlowKtor_httpURLBuilderCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpURLBuilderCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((swift_name("Ktor_httpParametersBuilder")))
@protocol FlowKtor_httpParametersBuilder <FlowKtor_utilsStringValuesBuilder>
@required
@end;

__attribute__((swift_name("KotlinKType")))
@protocol FlowKotlinKType
@required
@property (readonly) NSArray<FlowKotlinKTypeProjection *> *arguments __attribute__((swift_name("arguments")));
@property (readonly) id<FlowKotlinKClassifier> _Nullable classifier __attribute__((swift_name("classifier")));
@property (readonly) BOOL isMarkedNullable __attribute__((swift_name("isMarkedNullable")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol.Companion")))
@interface FlowKtor_httpURLProtocolCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpURLProtocolCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_httpURLProtocol *)createOrDefaultName:(NSString *)name __attribute__((swift_name("createOrDefault(name:)")));
@property (readonly) FlowKtor_httpURLProtocol *HTTP __attribute__((swift_name("HTTP")));
@property (readonly) FlowKtor_httpURLProtocol *HTTPS __attribute__((swift_name("HTTPS")));
@property (readonly) FlowKtor_httpURLProtocol *SOCKS __attribute__((swift_name("SOCKS")));
@property (readonly) FlowKtor_httpURLProtocol *WS __attribute__((swift_name("WS")));
@property (readonly) FlowKtor_httpURLProtocol *WSS __attribute__((swift_name("WSS")));
@property (readonly) NSDictionary<NSString *, FlowKtor_httpURLProtocol *> *byName __attribute__((swift_name("byName")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueParam")))
@interface FlowKtor_httpHeaderValueParam : FlowBase
- (instancetype)initWithName:(NSString *)name value:(NSString *)value __attribute__((swift_name("init(name:value:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithName:(NSString *)name value:(NSString *)value escapeValue:(BOOL)escapeValue __attribute__((swift_name("init(name:value:escapeValue:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (NSString *)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (BOOL)component3 __attribute__((swift_name("component3()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKtor_httpHeaderValueParam *)doCopyName:(NSString *)name value:(NSString *)value escapeValue:(BOOL)escapeValue __attribute__((swift_name("doCopy(name:value:escapeValue:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL escapeValue __attribute__((swift_name("escapeValue")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueWithParameters.Companion")))
@interface FlowKtor_httpHeaderValueWithParametersCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpHeaderValueWithParametersCompanion *shared __attribute__((swift_name("shared")));
- (id _Nullable)parseValue:(NSString *)value init:(id _Nullable (^)(NSString *, NSArray<FlowKtor_httpHeaderValueParam *> *))init __attribute__((swift_name("parse(value:init:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType.Companion")))
@interface FlowKtor_httpContentTypeCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_httpContentTypeCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_httpContentType *)parseValue:(NSString *)value __attribute__((swift_name("parse(value:)")));
@property (readonly) FlowKtor_httpContentType *Any __attribute__((swift_name("Any")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreParentJob")))
@protocol FlowKotlinx_coroutines_coreParentJob <FlowKotlinx_coroutines_coreJob>
@required
- (FlowKotlinCancellationException *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSelectInstance")))
@protocol FlowKotlinx_coroutines_coreSelectInstance
@required
- (void)disposeOnSelectHandle:(id<FlowKotlinx_coroutines_coreDisposableHandle>)handle __attribute__((swift_name("disposeOnSelect(handle:)")));
- (id _Nullable)performAtomicTrySelectDesc:(FlowKotlinx_coroutines_coreAtomicDesc *)desc __attribute__((swift_name("performAtomicTrySelect(desc:)")));
- (void)resumeSelectWithExceptionException:(FlowKotlinThrowable *)exception __attribute__((swift_name("resumeSelectWithException(exception:)")));
- (BOOL)trySelect __attribute__((swift_name("trySelect()")));
- (id _Nullable)trySelectOtherOtherOp:(FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp * _Nullable)otherOp __attribute__((swift_name("trySelectOther(otherOp:)")));
@property (readonly) id<FlowKotlinContinuation> completion __attribute__((swift_name("completion")));
@property (readonly) BOOL isSelected __attribute__((swift_name("isSelected")));
@end;

__attribute__((swift_name("KotlinSuspendFunction0")))
@protocol FlowKotlinSuspendFunction0 <FlowKotlinFunction>
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeWithCompletionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay.Companion")))
@interface FlowKtor_utilsWeekDayCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_utilsWeekDayCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_utilsWeekDay *)fromOrdinal:(int32_t)ordinal __attribute__((swift_name("from(ordinal:)")));
- (FlowKtor_utilsWeekDay *)fromValue:(NSString *)value __attribute__((swift_name("from(value:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth.Companion")))
@interface FlowKtor_utilsMonthCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_utilsMonthCompanion *shared __attribute__((swift_name("shared")));
- (FlowKtor_utilsMonth *)fromOrdinal:(int32_t)ordinal __attribute__((swift_name("from(ordinal:)")));
- (FlowKtor_utilsMonth *)fromValue:(NSString *)value __attribute__((swift_name("from(value:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioMemory.Companion")))
@interface FlowKtor_ioMemoryCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_ioMemoryCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_ioMemory *Empty __attribute__((swift_name("Empty")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioBuffer.Companion")))
@interface FlowKtor_ioBufferCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_ioBufferCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_ioBuffer *Empty __attribute__((swift_name("Empty")));
@property (readonly) int32_t ReservedSize __attribute__((swift_name("ReservedSize")));
@end;

__attribute__((swift_name("Ktor_ioObjectPool")))
@protocol FlowKtor_ioObjectPool <FlowKtor_ioCloseable>
@required
- (id)borrow __attribute__((swift_name("borrow()")));
- (void)dispose __attribute__((swift_name("dispose()")));
- (void)recycleInstance:(id)instance __attribute__((swift_name("recycle(instance:)")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioChunkBuffer.Companion")))
@interface FlowKtor_ioChunkBufferCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_ioChunkBufferCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_ioChunkBuffer *Empty __attribute__((swift_name("Empty")));
@property (readonly) id<FlowKtor_ioObjectPool> EmptyPool __attribute__((swift_name("EmptyPool")));
@property (readonly) id<FlowKtor_ioObjectPool> Pool __attribute__((swift_name("Pool")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioInput.Companion")))
@interface FlowKtor_ioInputCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_ioInputCompanion *shared __attribute__((swift_name("shared")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioByteReadPacket.Companion")))
@interface FlowKtor_ioByteReadPacketCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKtor_ioByteReadPacketCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) FlowKtor_ioByteReadPacket *Empty __attribute__((swift_name("Empty")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKTypeProjection")))
@interface FlowKotlinKTypeProjection : FlowBase
- (instancetype)initWithVariance:(FlowKotlinKVariance * _Nullable)variance type:(id<FlowKotlinKType> _Nullable)type __attribute__((swift_name("init(variance:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) FlowKotlinKTypeProjectionCompanion *companion __attribute__((swift_name("companion")));
- (FlowKotlinKVariance * _Nullable)component1 __attribute__((swift_name("component1()"))) __attribute__((deprecated("use corresponding property instead")));
- (id<FlowKotlinKType> _Nullable)component2 __attribute__((swift_name("component2()"))) __attribute__((deprecated("use corresponding property instead")));
- (FlowKotlinKTypeProjection *)doCopyVariance:(FlowKotlinKVariance * _Nullable)variance type:(id<FlowKotlinKType> _Nullable)type __attribute__((swift_name("doCopy(variance:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<FlowKotlinKType> _Nullable type __attribute__((swift_name("type")));
@property (readonly) FlowKotlinKVariance * _Nullable variance __attribute__((swift_name("variance")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicDesc")))
@interface FlowKotlinx_coroutines_coreAtomicDesc : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(FlowKotlinx_coroutines_coreAtomicOp<id> *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)prepareOp:(FlowKotlinx_coroutines_coreAtomicOp<id> *)op __attribute__((swift_name("prepare(op:)")));
@property FlowKotlinx_coroutines_coreAtomicOp<id> *atomicOp __attribute__((swift_name("atomicOp")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreOpDescriptor")))
@interface FlowKotlinx_coroutines_coreOpDescriptor : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)isEarlierThanThat:(FlowKotlinx_coroutines_coreOpDescriptor *)that __attribute__((swift_name("isEarlierThan(that:)")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKotlinx_coroutines_coreAtomicOp<id> * _Nullable atomicOp __attribute__((swift_name("atomicOp")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNode.PrepareOp")))
@interface FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp : FlowKotlinx_coroutines_coreOpDescriptor
- (instancetype)initWithAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next desc:(FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc *)desc __attribute__((swift_name("init(affected:next:desc:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)finishPrepare __attribute__((swift_name("finishPrepare()")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *affected __attribute__((swift_name("affected")));
@property (readonly) FlowKotlinx_coroutines_coreAtomicOp<id> *atomicOp __attribute__((swift_name("atomicOp")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc *desc __attribute__((swift_name("desc")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *next __attribute__((swift_name("next")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKVariance")))
@interface FlowKotlinKVariance : FlowKotlinEnum<FlowKotlinKVariance *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) FlowKotlinKVariance *invariant __attribute__((swift_name("invariant")));
@property (class, readonly) FlowKotlinKVariance *in __attribute__((swift_name("in")));
@property (class, readonly) FlowKotlinKVariance *out __attribute__((swift_name("out")));
+ (FlowKotlinArray<FlowKotlinKVariance *> *)values __attribute__((swift_name("values()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKTypeProjection.Companion")))
@interface FlowKotlinKTypeProjectionCompanion : FlowBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) FlowKotlinKTypeProjectionCompanion *shared __attribute__((swift_name("shared")));
- (FlowKotlinKTypeProjection *)contravariantType:(id<FlowKotlinKType>)type __attribute__((swift_name("contravariant(type:)")));
- (FlowKotlinKTypeProjection *)covariantType:(id<FlowKotlinKType>)type __attribute__((swift_name("covariant(type:)")));
- (FlowKotlinKTypeProjection *)invariantType:(id<FlowKotlinKType>)type __attribute__((swift_name("invariant(type:)")));
@property (readonly) FlowKotlinKTypeProjection *STAR __attribute__((swift_name("STAR")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreAtomicOp")))
@interface FlowKotlinx_coroutines_coreAtomicOp<__contravariant T> : FlowKotlinx_coroutines_coreOpDescriptor
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeAffected:(T _Nullable)affected failure:(id _Nullable)failure __attribute__((swift_name("complete(affected:failure:)")));
- (id _Nullable)decideDecision:(id _Nullable)decision __attribute__((swift_name("decide(decision:)")));
- (id _Nullable)performAffected:(id _Nullable)affected __attribute__((swift_name("perform(affected:)")));
- (id _Nullable)prepareAffected:(T _Nullable)affected __attribute__((swift_name("prepare(affected:)")));
@property (readonly) FlowKotlinx_coroutines_coreAtomicOp<id> *atomicOp __attribute__((swift_name("atomicOp")));
@property (readonly) id _Nullable consensus __attribute__((swift_name("consensus")));
@property (readonly) BOOL isDecided __attribute__((swift_name("isDecided")));
@property (readonly) int64_t opSequence __attribute__((swift_name("opSequence")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNode")))
@interface FlowKotlinx_coroutines_coreLockFreeLinkedListNode : FlowBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)addLastNode:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)node __attribute__((swift_name("addLast(node:)")));
- (BOOL)addLastIfNode:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)node condition:(FlowBoolean *(^)(void))condition __attribute__((swift_name("addLastIf(node:condition:)")));
- (BOOL)addLastIfPrevNode:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)node predicate:(FlowBoolean *(^)(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *))predicate __attribute__((swift_name("addLastIfPrev(node:predicate:)")));
- (BOOL)addLastIfPrevAndIfNode:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)node predicate:(FlowBoolean *(^)(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *))predicate condition:(FlowBoolean *(^)(void))condition __attribute__((swift_name("addLastIfPrevAndIf(node:predicate:condition:)")));
- (BOOL)addOneIfEmptyNode:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)node __attribute__((swift_name("addOneIfEmpty(node:)")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc<FlowKotlinx_coroutines_coreLockFreeLinkedListNode *> *)describeAddLastNode:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)node __attribute__((swift_name("describeAddLast(node:)")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc<FlowKotlinx_coroutines_coreLockFreeLinkedListNode *> *)describeRemoveFirst __attribute__((swift_name("describeRemoveFirst()")));
- (void)helpRemove __attribute__((swift_name("helpRemove()")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)nextIfRemoved __attribute__((swift_name("nextIfRemoved()")));
- (BOOL)remove __attribute__((swift_name("remove()")));
- (id _Nullable)removeFirstIfIsInstanceOfOrPeekIfPredicate:(FlowBoolean *(^)(id _Nullable))predicate __attribute__((swift_name("removeFirstIfIsInstanceOfOrPeekIf(predicate:)")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)removeFirstOrNull __attribute__((swift_name("removeFirstOrNull()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL isRemoved __attribute__((swift_name("isRemoved")));
@property (readonly, getter=next_) id next __attribute__((swift_name("next")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *nextNode __attribute__((swift_name("nextNode")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *prevNode __attribute__((swift_name("prevNode")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNode.AbstractAtomicDesc")))
@interface FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc : FlowKotlinx_coroutines_coreAtomicDesc
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)completeOp:(FlowKotlinx_coroutines_coreAtomicOp<id> *)op failure:(id _Nullable)failure __attribute__((swift_name("complete(op:failure:)")));
- (id _Nullable)failureAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected __attribute__((swift_name("failure(affected:)")));
- (void)finishOnSuccessAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("finishOnSuccess(affected:next:)")));
- (void)finishPreparePrepareOp:(FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("finishPrepare(prepareOp:)")));
- (id _Nullable)onPreparePrepareOp:(FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("onPrepare(prepareOp:)")));
- (void)onRemovedAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected __attribute__((swift_name("onRemoved(affected:)")));
- (id _Nullable)prepareOp:(FlowKotlinx_coroutines_coreAtomicOp<id> *)op __attribute__((swift_name("prepare(op:)")));
- (BOOL)retryAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(id)next __attribute__((swift_name("retry(affected:next:)")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)takeAffectedNodeOp:(FlowKotlinx_coroutines_coreOpDescriptor *)op __attribute__((swift_name("takeAffectedNode(op:)")));
- (id)updatedNextAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("updatedNext(affected:next:)")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable affectedNode __attribute__((swift_name("affectedNode")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable originalNext __attribute__((swift_name("originalNext")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc")))
@interface FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAddLastDesc<T> : FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc
- (instancetype)initWithQueue:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)queue node:(T)node __attribute__((swift_name("init(queue:node:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)finishOnSuccessAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("finishOnSuccess(affected:next:)")));
- (void)finishPreparePrepareOp:(FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("finishPrepare(prepareOp:)")));
- (BOOL)retryAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(id)next __attribute__((swift_name("retry(affected:next:)")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)takeAffectedNodeOp:(FlowKotlinx_coroutines_coreOpDescriptor *)op __attribute__((swift_name("takeAffectedNode(op:)")));
- (id)updatedNextAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("updatedNext(affected:next:)")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable affectedNode __attribute__((swift_name("affectedNode")));
@property (readonly) T node __attribute__((swift_name("node")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *originalNext __attribute__((swift_name("originalNext")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *queue __attribute__((swift_name("queue")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc")))
@interface FlowKotlinx_coroutines_coreLockFreeLinkedListNodeRemoveFirstDesc<T> : FlowKotlinx_coroutines_coreLockFreeLinkedListNodeAbstractAtomicDesc
- (instancetype)initWithQueue:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)queue __attribute__((swift_name("init(queue:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (id _Nullable)failureAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected __attribute__((swift_name("failure(affected:)")));
- (void)finishOnSuccessAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("finishOnSuccess(affected:next:)")));
- (void)finishPreparePrepareOp:(FlowKotlinx_coroutines_coreLockFreeLinkedListNodePrepareOp *)prepareOp __attribute__((swift_name("finishPrepare(prepareOp:)")));
- (BOOL)retryAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(id)next __attribute__((swift_name("retry(affected:next:)")));
- (FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable)takeAffectedNodeOp:(FlowKotlinx_coroutines_coreOpDescriptor *)op __attribute__((swift_name("takeAffectedNode(op:)")));
- (id)updatedNextAffected:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)affected next:(FlowKotlinx_coroutines_coreLockFreeLinkedListNode *)next __attribute__((swift_name("updatedNext(affected:next:)")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable affectedNode __attribute__((swift_name("affectedNode")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode * _Nullable originalNext __attribute__((swift_name("originalNext")));
@property (readonly) FlowKotlinx_coroutines_coreLockFreeLinkedListNode *queue __attribute__((swift_name("queue")));
@property (readonly) T _Nullable result __attribute__((swift_name("result")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END

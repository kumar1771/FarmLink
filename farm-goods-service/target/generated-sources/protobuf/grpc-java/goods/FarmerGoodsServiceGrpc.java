package goods;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: newgoods.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FarmerGoodsServiceGrpc {

  private FarmerGoodsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "FarmerGoodsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<goods.GoodsRequest,
      goods.GoodsResponse> getCreateNewGoodsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNewGoods",
      requestType = goods.GoodsRequest.class,
      responseType = goods.GoodsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<goods.GoodsRequest,
      goods.GoodsResponse> getCreateNewGoodsMethod() {
    io.grpc.MethodDescriptor<goods.GoodsRequest, goods.GoodsResponse> getCreateNewGoodsMethod;
    if ((getCreateNewGoodsMethod = FarmerGoodsServiceGrpc.getCreateNewGoodsMethod) == null) {
      synchronized (FarmerGoodsServiceGrpc.class) {
        if ((getCreateNewGoodsMethod = FarmerGoodsServiceGrpc.getCreateNewGoodsMethod) == null) {
          FarmerGoodsServiceGrpc.getCreateNewGoodsMethod = getCreateNewGoodsMethod =
              io.grpc.MethodDescriptor.<goods.GoodsRequest, goods.GoodsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNewGoods"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.GoodsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.GoodsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FarmerGoodsServiceMethodDescriptorSupplier("CreateNewGoods"))
              .build();
        }
      }
    }
    return getCreateNewGoodsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<goods.FGoodsList,
      goods.GoodsList> getPushGoodsBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PushGoodsBatch",
      requestType = goods.FGoodsList.class,
      responseType = goods.GoodsList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<goods.FGoodsList,
      goods.GoodsList> getPushGoodsBatchMethod() {
    io.grpc.MethodDescriptor<goods.FGoodsList, goods.GoodsList> getPushGoodsBatchMethod;
    if ((getPushGoodsBatchMethod = FarmerGoodsServiceGrpc.getPushGoodsBatchMethod) == null) {
      synchronized (FarmerGoodsServiceGrpc.class) {
        if ((getPushGoodsBatchMethod = FarmerGoodsServiceGrpc.getPushGoodsBatchMethod) == null) {
          FarmerGoodsServiceGrpc.getPushGoodsBatchMethod = getPushGoodsBatchMethod =
              io.grpc.MethodDescriptor.<goods.FGoodsList, goods.GoodsList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PushGoodsBatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.FGoodsList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.GoodsList.getDefaultInstance()))
              .setSchemaDescriptor(new FarmerGoodsServiceMethodDescriptorSupplier("PushGoodsBatch"))
              .build();
        }
      }
    }
    return getPushGoodsBatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<goods.CustomerDetails,
      goods.ListOfGoods> getCustomerRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CustomerRequest",
      requestType = goods.CustomerDetails.class,
      responseType = goods.ListOfGoods.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<goods.CustomerDetails,
      goods.ListOfGoods> getCustomerRequestMethod() {
    io.grpc.MethodDescriptor<goods.CustomerDetails, goods.ListOfGoods> getCustomerRequestMethod;
    if ((getCustomerRequestMethod = FarmerGoodsServiceGrpc.getCustomerRequestMethod) == null) {
      synchronized (FarmerGoodsServiceGrpc.class) {
        if ((getCustomerRequestMethod = FarmerGoodsServiceGrpc.getCustomerRequestMethod) == null) {
          FarmerGoodsServiceGrpc.getCustomerRequestMethod = getCustomerRequestMethod =
              io.grpc.MethodDescriptor.<goods.CustomerDetails, goods.ListOfGoods>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CustomerRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.CustomerDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.ListOfGoods.getDefaultInstance()))
              .setSchemaDescriptor(new FarmerGoodsServiceMethodDescriptorSupplier("CustomerRequest"))
              .build();
        }
      }
    }
    return getCustomerRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<goods.GoodsRequest,
      goods.ListOfGoods> getEditeGoodsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditeGoods",
      requestType = goods.GoodsRequest.class,
      responseType = goods.ListOfGoods.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<goods.GoodsRequest,
      goods.ListOfGoods> getEditeGoodsMethod() {
    io.grpc.MethodDescriptor<goods.GoodsRequest, goods.ListOfGoods> getEditeGoodsMethod;
    if ((getEditeGoodsMethod = FarmerGoodsServiceGrpc.getEditeGoodsMethod) == null) {
      synchronized (FarmerGoodsServiceGrpc.class) {
        if ((getEditeGoodsMethod = FarmerGoodsServiceGrpc.getEditeGoodsMethod) == null) {
          FarmerGoodsServiceGrpc.getEditeGoodsMethod = getEditeGoodsMethod =
              io.grpc.MethodDescriptor.<goods.GoodsRequest, goods.ListOfGoods>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EditeGoods"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.GoodsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  goods.ListOfGoods.getDefaultInstance()))
              .setSchemaDescriptor(new FarmerGoodsServiceMethodDescriptorSupplier("EditeGoods"))
              .build();
        }
      }
    }
    return getEditeGoodsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FarmerGoodsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmerGoodsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmerGoodsServiceStub>() {
        @java.lang.Override
        public FarmerGoodsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmerGoodsServiceStub(channel, callOptions);
        }
      };
    return FarmerGoodsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FarmerGoodsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmerGoodsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmerGoodsServiceBlockingStub>() {
        @java.lang.Override
        public FarmerGoodsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmerGoodsServiceBlockingStub(channel, callOptions);
        }
      };
    return FarmerGoodsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FarmerGoodsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmerGoodsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmerGoodsServiceFutureStub>() {
        @java.lang.Override
        public FarmerGoodsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmerGoodsServiceFutureStub(channel, callOptions);
        }
      };
    return FarmerGoodsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createNewGoods(goods.GoodsRequest request,
        io.grpc.stub.StreamObserver<goods.GoodsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNewGoodsMethod(), responseObserver);
    }

    /**
     */
    default void pushGoodsBatch(goods.FGoodsList request,
        io.grpc.stub.StreamObserver<goods.GoodsList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPushGoodsBatchMethod(), responseObserver);
    }

    /**
     */
    default void customerRequest(goods.CustomerDetails request,
        io.grpc.stub.StreamObserver<goods.ListOfGoods> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCustomerRequestMethod(), responseObserver);
    }

    /**
     */
    default void editeGoods(goods.GoodsRequest request,
        io.grpc.stub.StreamObserver<goods.ListOfGoods> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditeGoodsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FarmerGoodsService.
   */
  public static abstract class FarmerGoodsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FarmerGoodsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FarmerGoodsService.
   */
  public static final class FarmerGoodsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FarmerGoodsServiceStub> {
    private FarmerGoodsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmerGoodsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmerGoodsServiceStub(channel, callOptions);
    }

    /**
     */
    public void createNewGoods(goods.GoodsRequest request,
        io.grpc.stub.StreamObserver<goods.GoodsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNewGoodsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pushGoodsBatch(goods.FGoodsList request,
        io.grpc.stub.StreamObserver<goods.GoodsList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPushGoodsBatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void customerRequest(goods.CustomerDetails request,
        io.grpc.stub.StreamObserver<goods.ListOfGoods> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCustomerRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editeGoods(goods.GoodsRequest request,
        io.grpc.stub.StreamObserver<goods.ListOfGoods> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditeGoodsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FarmerGoodsService.
   */
  public static final class FarmerGoodsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FarmerGoodsServiceBlockingStub> {
    private FarmerGoodsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmerGoodsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmerGoodsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public goods.GoodsResponse createNewGoods(goods.GoodsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNewGoodsMethod(), getCallOptions(), request);
    }

    /**
     */
    public goods.GoodsList pushGoodsBatch(goods.FGoodsList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPushGoodsBatchMethod(), getCallOptions(), request);
    }

    /**
     */
    public goods.ListOfGoods customerRequest(goods.CustomerDetails request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCustomerRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public goods.ListOfGoods editeGoods(goods.GoodsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditeGoodsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FarmerGoodsService.
   */
  public static final class FarmerGoodsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FarmerGoodsServiceFutureStub> {
    private FarmerGoodsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmerGoodsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmerGoodsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<goods.GoodsResponse> createNewGoods(
        goods.GoodsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNewGoodsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<goods.GoodsList> pushGoodsBatch(
        goods.FGoodsList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPushGoodsBatchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<goods.ListOfGoods> customerRequest(
        goods.CustomerDetails request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCustomerRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<goods.ListOfGoods> editeGoods(
        goods.GoodsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditeGoodsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW_GOODS = 0;
  private static final int METHODID_PUSH_GOODS_BATCH = 1;
  private static final int METHODID_CUSTOMER_REQUEST = 2;
  private static final int METHODID_EDITE_GOODS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NEW_GOODS:
          serviceImpl.createNewGoods((goods.GoodsRequest) request,
              (io.grpc.stub.StreamObserver<goods.GoodsResponse>) responseObserver);
          break;
        case METHODID_PUSH_GOODS_BATCH:
          serviceImpl.pushGoodsBatch((goods.FGoodsList) request,
              (io.grpc.stub.StreamObserver<goods.GoodsList>) responseObserver);
          break;
        case METHODID_CUSTOMER_REQUEST:
          serviceImpl.customerRequest((goods.CustomerDetails) request,
              (io.grpc.stub.StreamObserver<goods.ListOfGoods>) responseObserver);
          break;
        case METHODID_EDITE_GOODS:
          serviceImpl.editeGoods((goods.GoodsRequest) request,
              (io.grpc.stub.StreamObserver<goods.ListOfGoods>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateNewGoodsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              goods.GoodsRequest,
              goods.GoodsResponse>(
                service, METHODID_CREATE_NEW_GOODS)))
        .addMethod(
          getPushGoodsBatchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              goods.FGoodsList,
              goods.GoodsList>(
                service, METHODID_PUSH_GOODS_BATCH)))
        .addMethod(
          getCustomerRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              goods.CustomerDetails,
              goods.ListOfGoods>(
                service, METHODID_CUSTOMER_REQUEST)))
        .addMethod(
          getEditeGoodsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              goods.GoodsRequest,
              goods.ListOfGoods>(
                service, METHODID_EDITE_GOODS)))
        .build();
  }

  private static abstract class FarmerGoodsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FarmerGoodsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return goods.Newgoods.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FarmerGoodsService");
    }
  }

  private static final class FarmerGoodsServiceFileDescriptorSupplier
      extends FarmerGoodsServiceBaseDescriptorSupplier {
    FarmerGoodsServiceFileDescriptorSupplier() {}
  }

  private static final class FarmerGoodsServiceMethodDescriptorSupplier
      extends FarmerGoodsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FarmerGoodsServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FarmerGoodsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FarmerGoodsServiceFileDescriptorSupplier())
              .addMethod(getCreateNewGoodsMethod())
              .addMethod(getPushGoodsBatchMethod())
              .addMethod(getCustomerRequestMethod())
              .addMethod(getEditeGoodsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

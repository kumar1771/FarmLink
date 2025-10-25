package newgoods;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: new_goods.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GoodsServiceGrpc {

  private GoodsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "GoodsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<newgoods.RequestNewGoods,
      newgoods.ResponseNewGoods> getCreateNewGoodsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createNewGoods",
      requestType = newgoods.RequestNewGoods.class,
      responseType = newgoods.ResponseNewGoods.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<newgoods.RequestNewGoods,
      newgoods.ResponseNewGoods> getCreateNewGoodsMethod() {
    io.grpc.MethodDescriptor<newgoods.RequestNewGoods, newgoods.ResponseNewGoods> getCreateNewGoodsMethod;
    if ((getCreateNewGoodsMethod = GoodsServiceGrpc.getCreateNewGoodsMethod) == null) {
      synchronized (GoodsServiceGrpc.class) {
        if ((getCreateNewGoodsMethod = GoodsServiceGrpc.getCreateNewGoodsMethod) == null) {
          GoodsServiceGrpc.getCreateNewGoodsMethod = getCreateNewGoodsMethod =
              io.grpc.MethodDescriptor.<newgoods.RequestNewGoods, newgoods.ResponseNewGoods>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createNewGoods"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  newgoods.RequestNewGoods.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  newgoods.ResponseNewGoods.getDefaultInstance()))
              .setSchemaDescriptor(new GoodsServiceMethodDescriptorSupplier("createNewGoods"))
              .build();
        }
      }
    }
    return getCreateNewGoodsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GoodsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GoodsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GoodsServiceStub>() {
        @java.lang.Override
        public GoodsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GoodsServiceStub(channel, callOptions);
        }
      };
    return GoodsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GoodsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GoodsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GoodsServiceBlockingStub>() {
        @java.lang.Override
        public GoodsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GoodsServiceBlockingStub(channel, callOptions);
        }
      };
    return GoodsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GoodsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GoodsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GoodsServiceFutureStub>() {
        @java.lang.Override
        public GoodsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GoodsServiceFutureStub(channel, callOptions);
        }
      };
    return GoodsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createNewGoods(newgoods.RequestNewGoods request,
        io.grpc.stub.StreamObserver<newgoods.ResponseNewGoods> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNewGoodsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GoodsService.
   */
  public static abstract class GoodsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GoodsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GoodsService.
   */
  public static final class GoodsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GoodsServiceStub> {
    private GoodsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GoodsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GoodsServiceStub(channel, callOptions);
    }

    /**
     */
    public void createNewGoods(newgoods.RequestNewGoods request,
        io.grpc.stub.StreamObserver<newgoods.ResponseNewGoods> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNewGoodsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GoodsService.
   */
  public static final class GoodsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GoodsServiceBlockingStub> {
    private GoodsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GoodsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GoodsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public newgoods.ResponseNewGoods createNewGoods(newgoods.RequestNewGoods request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNewGoodsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GoodsService.
   */
  public static final class GoodsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GoodsServiceFutureStub> {
    private GoodsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GoodsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GoodsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<newgoods.ResponseNewGoods> createNewGoods(
        newgoods.RequestNewGoods request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNewGoodsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW_GOODS = 0;

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
          serviceImpl.createNewGoods((newgoods.RequestNewGoods) request,
              (io.grpc.stub.StreamObserver<newgoods.ResponseNewGoods>) responseObserver);
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
              newgoods.RequestNewGoods,
              newgoods.ResponseNewGoods>(
                service, METHODID_CREATE_NEW_GOODS)))
        .build();
  }

  private static abstract class GoodsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GoodsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return newgoods.NewGoods.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GoodsService");
    }
  }

  private static final class GoodsServiceFileDescriptorSupplier
      extends GoodsServiceBaseDescriptorSupplier {
    GoodsServiceFileDescriptorSupplier() {}
  }

  private static final class GoodsServiceMethodDescriptorSupplier
      extends GoodsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GoodsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GoodsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GoodsServiceFileDescriptorSupplier())
              .addMethod(getCreateNewGoodsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

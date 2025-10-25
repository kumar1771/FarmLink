package orders;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: goodsOrder.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class orderGoodsGrpc {

  private orderGoodsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "orderGoods";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<orders.CustomerId,
      orders.ExistOrNot> getTakeNewOrderFromCustomerIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TakeNewOrderFromCustomerId",
      requestType = orders.CustomerId.class,
      responseType = orders.ExistOrNot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<orders.CustomerId,
      orders.ExistOrNot> getTakeNewOrderFromCustomerIdMethod() {
    io.grpc.MethodDescriptor<orders.CustomerId, orders.ExistOrNot> getTakeNewOrderFromCustomerIdMethod;
    if ((getTakeNewOrderFromCustomerIdMethod = orderGoodsGrpc.getTakeNewOrderFromCustomerIdMethod) == null) {
      synchronized (orderGoodsGrpc.class) {
        if ((getTakeNewOrderFromCustomerIdMethod = orderGoodsGrpc.getTakeNewOrderFromCustomerIdMethod) == null) {
          orderGoodsGrpc.getTakeNewOrderFromCustomerIdMethod = getTakeNewOrderFromCustomerIdMethod =
              io.grpc.MethodDescriptor.<orders.CustomerId, orders.ExistOrNot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TakeNewOrderFromCustomerId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  orders.CustomerId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  orders.ExistOrNot.getDefaultInstance()))
              .setSchemaDescriptor(new orderGoodsMethodDescriptorSupplier("TakeNewOrderFromCustomerId"))
              .build();
        }
      }
    }
    return getTakeNewOrderFromCustomerIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<orders.OrdersFromCustomer,
      orders.GoodsExist> getTakeNNumbersOfOrdersFromCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TakeNNumbersOfOrdersFromCustomer",
      requestType = orders.OrdersFromCustomer.class,
      responseType = orders.GoodsExist.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<orders.OrdersFromCustomer,
      orders.GoodsExist> getTakeNNumbersOfOrdersFromCustomerMethod() {
    io.grpc.MethodDescriptor<orders.OrdersFromCustomer, orders.GoodsExist> getTakeNNumbersOfOrdersFromCustomerMethod;
    if ((getTakeNNumbersOfOrdersFromCustomerMethod = orderGoodsGrpc.getTakeNNumbersOfOrdersFromCustomerMethod) == null) {
      synchronized (orderGoodsGrpc.class) {
        if ((getTakeNNumbersOfOrdersFromCustomerMethod = orderGoodsGrpc.getTakeNNumbersOfOrdersFromCustomerMethod) == null) {
          orderGoodsGrpc.getTakeNNumbersOfOrdersFromCustomerMethod = getTakeNNumbersOfOrdersFromCustomerMethod =
              io.grpc.MethodDescriptor.<orders.OrdersFromCustomer, orders.GoodsExist>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TakeNNumbersOfOrdersFromCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  orders.OrdersFromCustomer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  orders.GoodsExist.getDefaultInstance()))
              .setSchemaDescriptor(new orderGoodsMethodDescriptorSupplier("TakeNNumbersOfOrdersFromCustomer"))
              .build();
        }
      }
    }
    return getTakeNNumbersOfOrdersFromCustomerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static orderGoodsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<orderGoodsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<orderGoodsStub>() {
        @java.lang.Override
        public orderGoodsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new orderGoodsStub(channel, callOptions);
        }
      };
    return orderGoodsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static orderGoodsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<orderGoodsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<orderGoodsBlockingStub>() {
        @java.lang.Override
        public orderGoodsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new orderGoodsBlockingStub(channel, callOptions);
        }
      };
    return orderGoodsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static orderGoodsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<orderGoodsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<orderGoodsFutureStub>() {
        @java.lang.Override
        public orderGoodsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new orderGoodsFutureStub(channel, callOptions);
        }
      };
    return orderGoodsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void takeNewOrderFromCustomerId(orders.CustomerId request,
        io.grpc.stub.StreamObserver<orders.ExistOrNot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTakeNewOrderFromCustomerIdMethod(), responseObserver);
    }

    /**
     */
    default void takeNNumbersOfOrdersFromCustomer(orders.OrdersFromCustomer request,
        io.grpc.stub.StreamObserver<orders.GoodsExist> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTakeNNumbersOfOrdersFromCustomerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service orderGoods.
   */
  public static abstract class orderGoodsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return orderGoodsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service orderGoods.
   */
  public static final class orderGoodsStub
      extends io.grpc.stub.AbstractAsyncStub<orderGoodsStub> {
    private orderGoodsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected orderGoodsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new orderGoodsStub(channel, callOptions);
    }

    /**
     */
    public void takeNewOrderFromCustomerId(orders.CustomerId request,
        io.grpc.stub.StreamObserver<orders.ExistOrNot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTakeNewOrderFromCustomerIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void takeNNumbersOfOrdersFromCustomer(orders.OrdersFromCustomer request,
        io.grpc.stub.StreamObserver<orders.GoodsExist> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTakeNNumbersOfOrdersFromCustomerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service orderGoods.
   */
  public static final class orderGoodsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<orderGoodsBlockingStub> {
    private orderGoodsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected orderGoodsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new orderGoodsBlockingStub(channel, callOptions);
    }

    /**
     */
    public orders.ExistOrNot takeNewOrderFromCustomerId(orders.CustomerId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTakeNewOrderFromCustomerIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public orders.GoodsExist takeNNumbersOfOrdersFromCustomer(orders.OrdersFromCustomer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTakeNNumbersOfOrdersFromCustomerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service orderGoods.
   */
  public static final class orderGoodsFutureStub
      extends io.grpc.stub.AbstractFutureStub<orderGoodsFutureStub> {
    private orderGoodsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected orderGoodsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new orderGoodsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<orders.ExistOrNot> takeNewOrderFromCustomerId(
        orders.CustomerId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTakeNewOrderFromCustomerIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<orders.GoodsExist> takeNNumbersOfOrdersFromCustomer(
        orders.OrdersFromCustomer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTakeNNumbersOfOrdersFromCustomerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TAKE_NEW_ORDER_FROM_CUSTOMER_ID = 0;
  private static final int METHODID_TAKE_NNUMBERS_OF_ORDERS_FROM_CUSTOMER = 1;

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
        case METHODID_TAKE_NEW_ORDER_FROM_CUSTOMER_ID:
          serviceImpl.takeNewOrderFromCustomerId((orders.CustomerId) request,
              (io.grpc.stub.StreamObserver<orders.ExistOrNot>) responseObserver);
          break;
        case METHODID_TAKE_NNUMBERS_OF_ORDERS_FROM_CUSTOMER:
          serviceImpl.takeNNumbersOfOrdersFromCustomer((orders.OrdersFromCustomer) request,
              (io.grpc.stub.StreamObserver<orders.GoodsExist>) responseObserver);
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
          getTakeNewOrderFromCustomerIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              orders.CustomerId,
              orders.ExistOrNot>(
                service, METHODID_TAKE_NEW_ORDER_FROM_CUSTOMER_ID)))
        .addMethod(
          getTakeNNumbersOfOrdersFromCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              orders.OrdersFromCustomer,
              orders.GoodsExist>(
                service, METHODID_TAKE_NNUMBERS_OF_ORDERS_FROM_CUSTOMER)))
        .build();
  }

  private static abstract class orderGoodsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    orderGoodsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return orders.GoodsOrder.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("orderGoods");
    }
  }

  private static final class orderGoodsFileDescriptorSupplier
      extends orderGoodsBaseDescriptorSupplier {
    orderGoodsFileDescriptorSupplier() {}
  }

  private static final class orderGoodsMethodDescriptorSupplier
      extends orderGoodsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    orderGoodsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (orderGoodsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new orderGoodsFileDescriptorSupplier())
              .addMethod(getTakeNewOrderFromCustomerIdMethod())
              .addMethod(getTakeNNumbersOfOrdersFromCustomerMethod())
              .build();
        }
      }
    }
    return result;
  }
}

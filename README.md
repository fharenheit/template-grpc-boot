# Template gRPC + Spring Boot

Spring Boot + gRPC Template Project

## Requirements

* JDK 11
* Maven 3.8.1
* Spring Boot 3
* Spring Doc 2
* gRPC 1.54

## Python Client

Stub 코드를 생성하기 위한 툴을 설치하고 Protocol Buffer 파일을 지정하여 Stub 코드를 생성합니다.

```
pip3 install grpcio-tools
python -m grpc_tools.protoc -I../../protos --python_out=. --pyi_out=. --grpc_python_out=. .\HelloService.proto
```

생성한 Stub 코드는 다음의 형식과 같이 코드를 작성합니다.

```python
def run():
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = HelloService_pb2_grpc.GreeterStub(channel)
        response = stub.hello(HelloService_pb2_grpc.HelloRequest(name='you'))
        print("Greeter client received: " + response.message)
        response = stub.helloMap(helloworld_pb2.HelloRequestMap(name='you'))
        print("Greeter client received: " + response.message)
```
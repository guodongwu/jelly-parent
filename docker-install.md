# Docker Install List

## 1.Zookeeper Install

```dockerfile
docker run --privileged=true -d --name zookeeper --publish 2181:2181  -d zookeeper
```

## 2.Kafka Install

```dockerfile
docker run -d --name mykafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=127.0.0.1 --env KAFKA_ADVERTISED_PORT=9092 wurstmeister/kafka
```

## 3.ActiveMQ Install

```dockerfile
docker run -d --name activemq -p 61616:61616 -p 8161:8161 webcenter/activemq
```

## 4.RabbitMQ Install

```dockerfile
docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:management
```


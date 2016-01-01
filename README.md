# Unicorn
Unicorn은 객체 지향 언어로 개발된 UPPERCASE 클라이언트입니다. 이 프로젝트는 Unicorn에서 공통으로 사용되는 API의 원형에 대해 다룹니다.

## Connector
- Connector(String host, boolean secure, int webServerPort, int socketServerPort, ConnectedHandler connectedHandler, DisconnectedHandler disconnectedHandler)
- Connector(String host, int webServerPort, int socketServerPort, ConnectedHandler connectedHandler, DisconnectedHandler disconnectedHandler)

UPPERCASE 서버와의 접속 및 통신 작업을 처리하는 기본적인 클래스입니다.

### boolean isConnected()
서버에 접속되었는지 확인하는 메소드입니다.

### ConnectedHandler
서버와 접속되었을 때 실행되는 핸들러를 작성하기 위한 인터페이스입니다.

### DisconnectedHandler
서버와의 접속이 끊어졌을 때 실행되는 핸들러를 작성하기 위한 인터페이스입니다.

## Model

### CreateHandler

### GetHandler

### UpdateHandler

### RemoveHandler

### FindHandler

### CountHandler

### ExistsHandler

## RoomConnector(String host, int port, ConnectedHandler connectedHandler, DisconnectedHandler disconnectedHandler)
[UPPERCASE-ROOM](https://github.com/Hanul/UPPERCASE/blob/master/DOC/UPPERCASE-ROOM.md) 모듈의 룸 서버에 접속 및 통신 작업을 처리하는 클래스입니다.

### DisconnectedHandler
서버와의 접속이 끊어졌을 때 처리하는 핸들러를 작성하기 위한 인터페이스입니다.

## Room

### Handler

## JSONUtil
Unicorn 내부적으로 사용하는 JSON 유틸리티입니다.

## 구현체
- [Unicorn-Android](https://github.com/Hanul/Unicorn-Android)
- [Unicorn-iOS](https://github.com/Hanul/Unicorn-iOS)
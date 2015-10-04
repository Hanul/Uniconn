# UPPERCASE.IO-Java-Client

UPPERCASE.IO Java client for Java or Android project.

### Install
Just add [UPPERCASE.IO-Java-Client.jar](https://github.com/Hanul/UPPERCASE.IO-Java-Client/raw/master/UPPERCASE.IO-Java-Client.jar) on the build path.
* you need [UPPERCASE.JAVA-JSON-UTIL.jar](https://github.com/Hanul/UPPERCASE.JAVA-JSON-UTIL)
* for normal Java project(not Android project), you need [JSON-java](https://github.com/douglascrockford/JSON-java).

### ROOM

ROOM EXAMPLE
```java
CONNECT_TO_IO_SERVER("127.0.0.1", 9126, 9127, new DisconnectedHandler() {
	
	@Override
    public void handle() {
		...
    }
});

ROOM room = new ROOM("TestBox", "testRoom");

room.on("msg", new Handler() {

    @Override
    public void handle(Object data) {
        System.out.println(data);
    }
});

JSONObject data = new JSONObject();
data.put("test2", "Hello, Test2!");
data.put("date", new Date());

System.out.println(room.send("msg", data, true));
```

### MODEL

MODEL EXAMPLE
```java
CONNECT_TO_IO_SERVER("127.0.0.1", 9126);

MODEL TestModel = new MODEL("TestBox", "Test");

JSONObject data = new JSONObject();
data.put("name", "YJ Sim");
data.put("age", 27);
data.put("isMan", true);

TestModel.onNew(new Handler() {

    @Override
    public void handle(Object savedData) {
        System.out.println("ON NEW: " + savedData);
    }
});

Map<String, Object> properties = new HashMap<String, Object>();
properties.put("age", 27);

TestModel.onNew(properties, new Handler() {

    @Override
    public void handle(Object savedData) {
        System.out.println("ON NEW when age is 27: " + savedData);
    }
});

JSONObject savedData = TestModel.create(data);

System.out.println("CREATE: " + savedData);
System.out.println("FIND: " + TestModel.find());
System.out.println("GET: " + TestModel.get(savedData.getString("id")));

savedData.put("name", "DS Hwang");
savedData = TestModel.update(savedData);

System.out.println("UPDATE: " + savedData);
System.out.println("REMOVE: " + TestModel.remove(savedData.getString("id")));
System.out.println("COUNT: " + TestModel.count());
System.out.println("CHECK IS EXISTS: " + TestModel.checkIsExists());
```

## License
[MIT](LICENSE)

## Author
[Young Jae Sim](https://github.com/Hanul)

## Contact
* [Facebook UPPERCASE.IO User Group](https://www.facebook.com/groups/uppercase/)
* [GitHub Issues](https://github.com/Hanul/UPPERCASE.IO-Java-Client/issues)

#### RMI

RMI:Remote Method Invocation
RPC/serialize/socket

***

* 优点：分布式，封装细节，使调用远程方法与调用本地方法一样方便，传递对象类型的返回值和参数
* 缺点：比本地执行慢
* RMI的过程是：客户对象一旦被调用，客户对象调用**stub**，stub调用网络远端的**skeleton**，而skeleton最终调用真正的服务对象。
由此，在调用客户对象的时候，感觉上就是直接调用了真正的服务对象。
- - -
* RMI&JMS
RMI：请求应答，同步，紧耦合
JMS：消息通知，一般是异步，松耦合

* RMI&RPC
PRC：跨语言，XRD数据，通过方法名匹配
RMI：java，对象序列化传递，远程接口方法签名

* RMI&Webservice
RMI:传递序列化java对象，java，java平台
Sebservice:传递XML格式数据，语言/平台无关

* JMS&Webservic
JMS：异步，java，三方交互customer，producer
Webservice：同步，xml，客户端调用Service服务
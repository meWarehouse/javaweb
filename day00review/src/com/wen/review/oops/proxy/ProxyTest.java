package com.wen.review.oops.proxy;


public class ProxyTest {
	/*
	 * 
	 * 接口的应用：代理模式
	 * 
	 */
	
	public static void main(String[] args) {
		
		ProxyServer proxyServer = new ProxyServer(new Server());
		
		proxyServer.browse();
	}
	
}

interface NetWork{
	public void browse();
}

//被代理类
class Server implements NetWork{

	@Override
	public void browse() {
		System.out.println("真实的服务器访问网络");
	}
	
}

//代理类
class ProxyServer implements NetWork{
	
	private NetWork work;
	
	public ProxyServer(NetWork work){
		this.work  = work;
	}
	
	private void check(){
		System.out.println("连网前检查工作");
	}

	@Override
	public void browse() {
		check();
		work.browse();
	}
	
}







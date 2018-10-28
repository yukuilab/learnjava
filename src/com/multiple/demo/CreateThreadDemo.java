package com.multiple.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateThreadDemo {
	
	public static void main(String[] args){
		
		//1. 继承Thread
		Thread t1 = new Thread(){
			@Override
			public void run(){
				System.out.println("继承Thread");
				super.run();
			}
		};
		t1.start();
		
		//2.实现Runnable接口
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("实现Runnable接口");
			}
		});
		t2.start();
		
		//3. 实现Callable接口
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<String> future = service.submit(new Callable(){
			
			@Override
			public String call() throws Exception{
				return "通过实现Callable接口";
			}
		});
		
		try{
			String result = future.get();
			System.out.println(result);
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch (ExecutionException e ) {
			e.printStackTrace();
		}
	}

}

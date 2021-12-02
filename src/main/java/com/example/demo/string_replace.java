package com.example.demo;

public class string_replace {
	public static void main(String[] args) {
		String url = "<figure class='media'><oembed url='https://www.youtube.com/watch?v=dCNmYHOhCoQ'></oembed></figure>";
			
		System.out.println(url);
		
		url = url.replaceAll("<figure class='media'><oembed url='", "");
		url = url.replace("'></oembed></figure>", "");
		url = url.replace(" ", "");
		
		System.out.println(url);
		
	}

}

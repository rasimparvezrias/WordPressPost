package com.intbit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author intbit
 */
public class WordPressPost {

	private final String userName;
	private final String password;
	private final String userId;
	private final XmlRpcClient client;

	public static void main(String[] args) {

	}

	public WordPressPost(String userName, String password, String userId, String wordPressURL)
			throws MalformedURLException {
		this.userName = userName;
		this.password = password;
		this.userId = userId;

		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(wordPressURL));
		client = new XmlRpcClient();
		client.setConfig(config);
	}

	public String addpost(Map<String, Object> postDetails) throws XmlRpcException {
		Object[] params = new Object[] { this.userId, this.userName, this.password, postDetails, Boolean.TRUE };
		return (String) client.execute("metaWeblog.newPost", params);

	}

	public Object addimage(HashMap<String, Object> images) throws XmlRpcException {
		Object[] imgs = new Object[] { this.userId, this.userName, this.password, images, Boolean.TRUE };
		return (Object) client.execute("metaWeblog.newMediaObject", imgs);

	}

	public Object deletepost(Integer postId, Map<String, Object> postDelete) throws XmlRpcException {
		Object[] delete = new Object[] { this.userId, this.userName, this.password, postId, Boolean.TRUE };
		return (Object) client.execute("wp.deletePost", delete);

	}

	public Object updatePost(Integer postId, Map<String, Object> updatePost) throws XmlRpcException {
		Object[] delete = new Object[] { 4137, this.userName, this.password, postId, Boolean.TRUE };
		return (Object) client.execute("metaWeblog.editPost", delete);

	}

}

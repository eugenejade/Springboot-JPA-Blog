package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import antlr.collections.List;
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터 //
	private String content; // 섬머노트 라이브러리 <html>태그 有
	
	@ColumnDefault("0")
	private int count; //조회수
	
	@ManyToOne(fetch = FetchType.EAGER) //many=board, user=one
	@JoinColumn(name="userId")
	private User user; //db는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy="board", fetch = FetchType.EAGER) //mappedBy 연관관계의 주인이 아니다 //FK가 아니다 
	private java.util.List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;

	public Board(Long id, String title, String content, int count, User user, java.util.List<Reply> reply,
			Timestamp createDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
		this.user = user;
		this.reply = reply;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public java.util.List<Reply> getReply() {
		return reply;
	}

	public void setReply(java.util.List<Reply> reply) {
		this.reply = reply;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	
}

package com.newproject.Journalapp.entity;

import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class JournalEntry
{

    private String id;
    private String title;
    private String content;

    public String getId()
    {
        return id;
    }
    public String getTitle() {
        return title;
    }
    //...................
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    //.....................
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}

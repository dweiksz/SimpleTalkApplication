# SimpleTalk

## Introduction

SimpleTalk is a purely text based social media web app that would allow users to create posts for others to view. The text within the post could be status updates, stories, or anything else they would like to share. Users can share links, but all links shared on the app will assure the user of the final destination before
redirecting, helping users stay more secure. Users will have the ability to subscribe to other users to consistently view posts from other creators. 

The text font, color, and background will be customizable for every post; allowing users to add some artistic flare to everything they would like to share. Posts are
unlimited, and users that consistently post will be rewarded with additional options for customization. All posts will have the ability to be edited or deleted after 
posting. 


SimpleTalk will consist of two main pages: an explore page, and a profile page. Both pages will consist of a simple and intuitive UI for users to navigate. The
explore page will be where users can create posts, as well as find others to subscribe to. The profile page will consist of some personal information as well as
preferences (tags) that will fill their explore page with posts that match their interests.


Because SimpleTalk is only text, filtering inappropriate content will be much easier than with pictures. Along with the ease of filtering, the fact that posts are only
text also means database storage requirements will be much smaller as well. 




## Storyboard
[Storyboard in FluidUI](https://www.fluidui.com/editor/live/preview/cF9TTW1jTkthZVRzVEhYYks4Qk5laEhMcFpwODZJd0ljWg==)


## Functional Requirements

1. As a user of SimpleTalk, I want to be able to view posts from others when using the application so that I can stay informed on others' expressions. 
- *Given*: A feed of posts from others is available
- *When*: The user creates an account on SimpleTalk
- *When*: The user subscribes to other users
- *Then*: The user will be able to view and interact with others posts.

2. As a user of SimpleTalk, I want to be able to create posts when using the application so that I can express my thoughts and engage with others.
- *Given*: The user posts a message
- *When*: The user creates an account on SimpleTalk
- *When*: The user clicks the create a post button
- *When*: The user types and customizes their post
- *When*: The user clicks the "Save and Post" button
- *Then*: The user will be able to create and view a post.

## Class Diagram

![SimpleTalkClassDiagram](https://github.com/dweiksz/SimpleTalk/blob/main/SimpleTalkClassDiagram.drawio.png)


### Class Diagram Description

**RetrofitClientInstance:** Bootstrap class required for Retrofit.

**Post:** class that represents a single post 

**User:**  class that represents a single user

**IPostDAO:** Interface for Retrofit to find and parse post JSON

**IForumDAO:** Interface for Retrofit to find and parse post JSON to forum

**IPostService:** Service (business logic class) for Post

## JSON Schema

This is what we plan to export to another app.
>  {
>  "type" : "object",
>  "properties" : {
>   "postID" : {
>      "type" : "int"
>    },
>   "userID" : {
>      "type" : "int"
>    },
>   "username" : {
>      "type" : "string"
>    },
>   "message" : {
>      "type" : "string"
>    },
>    "likes" : {
>      "type" : "int"
>    }
>  }
> }


## Scrum Roles
DevOps/Product Owner - Jacob Macleod  
UI Specialist/GitHub Admin - Saleem Dweik  
Business Logic - Brennan Hand  
UI Specialist - Anish Selar  
Business Logic - Matthew Abbott  



## GitHub Repository Link
GitHub Link: https://github.com/dweiksz/SimpleTalk




## Scrum/Kanban Board
*In Projects*


## Teams Link
Teams meeting link (6pm Sunday): Will email to professor.

# SimpleTalk

## Introduction

SimpleTalk is a purely text-based social media web app that allow users to create posts for others to view. The text within the post could be status updates, stories, or anything else they would like to share. Users can share links, but all links shared on the app will assure the user of the final destination before
redirecting, helping users stay more secure. Users will have the ability to subscribe to other users to consistently view posts from other creators.

The text font, color, and background will be customizable for every post; allowing users to add some artistic flare to everything they would like to share. Posts are
unlimited, and users that consistently post will be rewarded with additional options for customization. All posts will have the ability to be edited or deleted after
posting.


SimpleTalk will consist of two main pages: an explore page and a profile page. Both pages will consist of a simple and intuitive UI for users to navigate. The
explore page will be where users can create posts, as well as find others to subscribe to. The profile page will consist of some personal information as well as
preferences (tags) that will fill their explore page with posts that match their interests.


Because SimpleTalk is only text, filtering inappropriate content will be much easier than with pictures. Along with the ease of filtering, the fact that posts are only
the text also means database storage requirements will be much smaller as well.


---

## Storyboard
[Storyboard in FluidUI](https://www.fluidui.com/editor/live/preview/cF9TTW1jTkthZVRzVEhYYks4Qk5laEhMcFpwODZJd0ljWg==)

---

## Functional Requirements

>  1. As a user of SimpleTalk, I want to be able to view posts from others when using the application so that I can stay informed on others' expressions. 

### Example
- *Given*: A feed of posts from others is available
- *When*: The user creates an account on SimpleTalk
- *Then*: The user will be able to view and interact with others posts.

### Example
- *Given*: A post is selected
- *When*: The user selects the user of the post
- *Then*: The user details selected will be viewable by the selector.

### Example
- *Given*: A user searches a thread  
- *When*: The user/service searches for "fhadkjlsjajfh" or doesn't match an existing thread.
- *Then*: SimpleTalk will not return any results and will be unable to post

> 2. As a user of SimpleTalk, I want to be able to create posts when using the application so that I can express my thoughts and engage with others.

### Example
- *Given*: The user wants to join SimpleTalk to have "write" privileges
- *When*: The user creates an account on SimpleTalk
- *Then*: The user will be able to create a profile.

### Example
- *Given*: The user wants to post on a thread in SimpleTalk
- *When*: The user selects a thread and posts a message
- *Then*: The user will be able to create a viewable post.


### Example
- *Given*: The user wants to remove a post
- *When*: The user must select their profile and select delete on the post
- *Then*: The user will be able to remove a post.

### Example
- *Given*: The user wants to like a post
- *When*: The user must select the like icon on the post
- *Then*: The user will be able to like a post.

---

## Class Diagram

![SimpleTalkClassDiagram](https://github.com/dweiksz/SimpleTalk/blob/main/SimpleTalkClassDiagram.drawio.png)

---

### Class Diagram Description

**RetrofitClientInstance:** Bootstrap class required for Retrofit.

**Post:** class that represents a single post 

**User:**  class that represents a single user

**IPostDAO:** Interface for Retrofit to find and parse post JSON

**IForumDAO:** Interface for Retrofit to find and parse post JSON to forum

**IPostService:** Service (business logic class) for Post

---

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


---

## Scrum Roles
DevOps/Product Owner/Business Logic - Brennan Hand  
UI Specialist - Jacob Macleod  
Business Logic/GitHub Admin - Saleem Dweik  
UI Specialist - Anish Selar  
Business Logic - Matthew Abbott  



---

## GitHub Repository Link
GitHub Link: https://github.com/dweiksz/SimpleTalkApplication


---

## Scrum/Kanban Board
*In Projects* - Under [SimpleTalkApplication](https://github.com/users/dweiksz/projects/2)

---


## Teams Link
Teams meeting link (6pm Sunday): Will email to professor.

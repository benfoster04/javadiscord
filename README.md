# javadiscord
A simple HTTP client and quick embed generator that allows for easy sending of embeds to Discord channels using webhooks. The code is easy to implement, setup, and use.

## Setup
Create files of the same name in your package and copy the respective code into them.
Add your package at the top of the files.
Import the files into your main code file.
In the Discord channel you wish to use, create a new webhook and copy the URL.

## Usage
Firstly, initialise a new webhook instance by doing:
```java
Webhook w = new Webhook("webhook URL");
```
Replace webhook URL with the acutal webhook URL you wish to use. This should already be in your clipboard.

Next, you want to create your embed. At the moment, the code is in it's basic stages, so you can only add a title, description, and colour to your embed.

To make your embed, you must do the following:
```java
Embed e = new Embed();
```
What you just did here is initialise a new embed class.

Now what you can do is use the functions to add titles, description, and colour to the embed individually. You must have either a title or a description present in your embed, or else it will not work. Colour is optional. However, you can do this all within the initialisation itself, by doing:
```java
Embed e = new Embed("Example Title","Example Description","hex colour without #");
```
The functions for the class can be found below. Also note that the default colour, if not defined, is #2A002A. Which is a dark purple colour.

Once you've created your embed, you need to send it by doing:
```java
w.send(e);
```
Now you should see your embed in the channel.


While you can do all this line by line as I've done above, you can do this all in 1 line or more.
For example, if I had multiple events that all send a different embed to the same channel, you can do put this as a child of the parent of the listeners:
```java
Webhook w = new Webhook("url");
```
Then have the seperate embeds inside each event as:
```java
w.send(new Embed("title","description"));
```

Another case would be only having to send one embed in the program. Ever.
```java
new Webhook("url").send(new Embed("title","description"));
```
This is a quick and easy one line to sending an embed.

## Functions and Methods
```java
new Webhook( String <Webhook URL> )
```
Creates a new Webhook instance. String parameter of Webhook URL is required.

```java
Webhook.send( Embed );
```
This sends the embed to the already defined webhook url

```java
new Embed( String <title>, String <description>, String <colour> )
```
This creates a new Embed instance. Either title or description, or both, must be defined at some point into the instance or the code will not work. Colour should be a hexadecimal colour without the hashtag (#)

```java
new Embed( String <title> )
```
Creates a new Embed instance with only title defined. Methods to add description and colour can be used also. The title can also be redefined using the setTitle method.

```java
new Embed( String <title>, String <description> )
```
Creates a new Embed Instance with both title and description defined. Method to add colour can be used also. The title and description can also be redefined using the setTitle and setDesc methods.

```java
Embed.setTitle( String <title> )
```
Sets the title of an already initialised Embed instance.

```java
Embed.setDesc( String <description> )
```
Sets the description of an already initialised Embed instance.

```java
Embed.setColour( String <colour> )
```
Sets the colour of an already initialised Embed instance. Format must not include hashtag (#) of hexadeciaml colour.

```java
(JSONObject) Embed.rtrn()
```
Returns the JSONObject class of the embed. .toJSONString() method is also available here to have webhook appplication/json content-type usable body.

## License
[MIT](https://choosealicense.com/licenses/mit/)
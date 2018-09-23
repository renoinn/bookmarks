<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>Hello Spring</title>
    </head>
    <body>
        <form role="form" action="/bookmark/add" method="POST">
            <div>
                <label for="url">url</label>
                <input type="input" name="url" id="url" required autofocus/>
            </div>
            <div>
                 <label for="title">title</label>
                 <input type="input" name="title" id="title" required/>
            </div>
            <div>
                <textarea name="note" id="note"></textarea>
            </div>
            <div>
                 <label for="tags">tag</label>
                 <input type="input" name="tags" id="tags"/>
            </div>
            <ul>
            <#list tags as tag>
                <li>${tag.tagName}</li>
            </#list>
            </ul>
            <button type="submit">submit</button>
        </form>
    </body>
</html>
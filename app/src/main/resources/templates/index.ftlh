<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>Hello Spring</title>
    </head>
    <body>
        <form role="form" action="/login" method="POST">
            <div>
                <label for="username">username</label>
                <input type="input" name="username" id="username" required autofocus/>
            </div>
            <div>
                 <label for="password">password</label>
                 <input type="password" name="password" id="password" required/>
            </div>
            <button type="submit">submit</button>
        </form>
    </body>
</html>
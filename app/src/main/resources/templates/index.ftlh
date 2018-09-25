<#import "/__wrapper.ftlh" as wrapper>
<@wrapper.main>

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

</@wrapper.main>
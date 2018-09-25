<#import "/__wrapper.ftlh" as wrapper>
<@wrapper.main>

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
            <div id="tag-input">
                <div>
                <label for="tags">tag</label>
                <input type="input" name="tags" id="tags" v-model="tags"/>
                <ul>
                    <#list tags as tag>
                        <li v-on:click="onClickHandler('${tag.tagName}')">${tag.tagName}</li>
                    </#list>
                </ul>
                </div>
            </div>

            <button type="submit">submit</button>
        </form>

</@wrapper.main>
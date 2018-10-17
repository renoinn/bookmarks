<#import "/__wrapper.ftlh" as wrapper>
<@wrapper.main>

<ul>
<#list bookmarks as bookmark>
    <li>
        <p>${bookmark.site.title}</p>
        <#list bookmark.tags as tag><span>${tag.tagName}</span></#list>
    </li>
</#list>
</ul>

</@wrapper.main>
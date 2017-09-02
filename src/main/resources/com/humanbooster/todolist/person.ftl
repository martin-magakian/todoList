<#-- @ftlvariable name="" type="com.humanbooster.todolist.Person" -->
<html>
    <body>
        <!-- calls getPerson().getName() and sanitizes it -->
        <h1>Hello ${person.name?html}!</h1>
        <p>How are you ?</p>
    </body>
</html>
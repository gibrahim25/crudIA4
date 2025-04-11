<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Create Animal</title>

    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

<!-- Begin Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #799351;">
    <a class="navbar-brand" href="/animals/all" style="margin: 10px;">
        <img src="/images/logo.jpg" alt="" width="80" height="60">
    </a>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" href="/animals/all">Home</a>
        </li>
    </ul>
</nav>

<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <form action="/animals/new" method="post">
        <input type="text" id="name" name="name" placeholder="Animal Name" required/>
        <input type="text" id="species" name="species" placeholder="Species" required/>
        <textarea id="description" name="description" placeholder="Description" rows="4" required></textarea>
        <button type="submit" class="btn btn-primary">Create Animal</button>
        <a href="/animals/all" class="btn btn-outline-danger">Cancel</a>
    </form>
</div>

</body>
</html>

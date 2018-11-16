# weatherboy
> weather for the soul :sunny:

Small Java 8 app built for [LTS beratung](https://angel.co/lts-beratung-1)'s job application.

## Problem statement

1. Create a small application with Java (8 or above), that starts up a webserver with an API that listens to GET /weather/<city>

The server makes a JaxRS/Jersey connection to https://openweathermap.org/current (free account possible), gives it the city, gets a response and parses the weather description into a response JSON like

```
{
	condition: Light intensity drizzle,
	temperature: 20.0
}
```

This JSON is sent to our caller.

2. Put it into a Docker container via Dockerfile. I do not need to know what happens inside the container, it just should make your API listen to 8080 when started.

3. Provide me a link `<the_url_povided_by_you>` to the Docker Registry / Container (docker.io?) so that I can download your docker container

4. I (I) should be able to do the following in my bash shell:

`docker start -o 8080:8080 <the_url_povided_by_you>`

```
curl https://localhost:8080

{
	hello: world
}
```

That is, I should be able to download it, start it, portforward the 8080 and do a curl to see the JSON you created.

5. Create an OpenAPI documentation for your API (OpenAPI 3) and check it in

6. Send me a link to the git source code of the entire project.

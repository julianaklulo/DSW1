package server

class UrlMappings {

    static mappings = {
        "/sites"(resources:"site")
        "/promocoes"(resources:"promocao")
        "/teatros"(resources:"teatro")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}

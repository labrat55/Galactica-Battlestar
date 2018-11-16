var app = new Vue({
    el: '#leaderboard',
    data: {scoreData: []
        
    },
    methods: {
        getDataObject: function (gamePlayer) {
            var fetchConfig =
                fetch("/api/leaderboard/", {
                    method: "GET",
                    credential: "include"
                }).then(this.onDataFetched)
        },
        onConversionToJsonSuccessful: function (json) {
            app.scoreData = json;
            console.log(this.scoreData)
           
        },
        onDataFetched: function (response) {
            response.json()
                .then(this.onConversionToJsonSuccessful)
        }
    },
    created: function(){
        this.getDataObject()
    }
})


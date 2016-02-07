System.register(["./hero"], function(exports_1) {
    var hero_1;
    var HEROES;
    return {
        setters:[
            function (hero_1_1) {
                hero_1 = hero_1_1;
            }],
        execute: function() {
            exports_1("HEROES", HEROES = [
                new hero_1.Hero(11, "Mr. Nice", "Being super nice to other people", "Mr Rogers"),
                new hero_1.Hero(12, "Narco", "Able to ingest wonderous amount of drugs"),
                new hero_1.Hero(13, "Bombasto", "Everything he touches explodes", "Dan Emite"),
                new hero_1.Hero(14, "Celeritas", "Super speed"),
                new hero_1.Hero(15, "Magneta", "Magnetic powers"),
                new hero_1.Hero(16, "RubberMan", "Shapeshifter"),
                new hero_1.Hero(17, "Dynama", "Shoots lighting", "Eliza Powers"),
                new hero_1.Hero(18, "Dr IQ", "Super intelligence", "Harry Brainiac"),
                new hero_1.Hero(19, "Magma", "Heat-based powers", "Rita Hott"),
                new hero_1.Hero(20, "Tornada", "Controls weather")
            ]);
        }
    }
});
//# sourceMappingURL=mock-heroes.js.map
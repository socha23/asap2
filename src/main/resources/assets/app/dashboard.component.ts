import {Component, OnInit} from 'angular2/core'
import {HeroService} from "./hero.service"
import {Hero} from "./hero"

@Component({
    selector: 'my-dashboard',
    templateUrl: 'app/dashboard.component.html'
})
export class DashboardComponent {
    heroes: Hero[] = [];

    constructor(private _heroService: HeroService) {}

    ngOnInit() {
        this._heroService.getHeroes()
            .then(heroes => this.heroes = heroes.slice(1, 5));
    }

    gotoDetail() {

    }

}


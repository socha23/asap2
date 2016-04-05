import {Component} from 'angular2/core'
import {HTTP_PROVIDERS} from 'angular2/http'
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from 'angular2/router'
import {HeroesComponent} from './heroes.component'
import {DashboardComponent} from './dashboard.component'
import {HeroService} from './hero.service'
import {HeroDetailComponent} from "./hero-detail.component"

@RouteConfig([
    {
        path: '/heroes',
        name: 'Heroes',
        component: HeroesComponent
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: DashboardComponent,
        useAsDefault: true
    },
    {
        path: '/detail/:id',
        name: 'HeroDetail',
        component: HeroDetailComponent
    }
])
@Component({
    selector: 'my-app',
    directives: [ROUTER_DIRECTIVES],
    styleUrls: ['app/app.component.css'],
    template: `
        <h1>{{title}}</h1>
        <nav>
        <a [routerLink]="['Dashboard']">Dashboard</a>
        <a [routerLink]="['Heroes']">Heroes</a>
        </nav>
        <router-outlet></router-outlet>

    `,
    providers: [
        ROUTER_PROVIDERS,
        HTTP_PROVIDERS,
        HeroService
    ]
})
export class AppComponent {
    public title = 'Tour of Heroes';


}
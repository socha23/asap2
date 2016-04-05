import {HEROES} from './mock-heroes';
import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Observable} from 'rxjs/Observable';
import {Hero} from "./hero";

@Injectable()
export class HeroService {
    constructor(private http: Http) {}

    private _heroesUrl = 'api/heroes';

    getHeroes() {
        return this.http.get(this._heroesUrl)
            .map(res => <Hero[]>res.json().data)
            .do(data => console.log(data))
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'Server error');
    }

    getHero(id) {
        return Promise.resolve(HEROES).then(
            heroes => heroes.filter(hero => hero.id === id)[0]
        );
    }

    addHero(name: string) : Observable<Hero> {
        let body = JSON.stringify({name});
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post(this._heroesUrl, body, options)
            .map(res => <Hero>res.json().data)
            .catch(this.handleError);
    }
}
import {Component} from 'angular2/core';
import {Form} from 'angular2/common';
import {Hero} from './hero';

@Component({
    selector: 'hero-form',
    templateUrl: 'app/hero-form.component.html'
})
export class HeroFormComponent {

    powers = [
        "Being super nice to other people",
        "Able to ingest wonderous amount of drugs",
        "Everything he touches explodes",
        "Super speed",
        "Magnetic powers",
        "Shapeshifter",
        "Shoots lighting",
        "Super intelligence",
        "Heat-based powers",
        "Controls weather"
    ];

    model = new Hero(18, "Dr IQ", "Super intelligence", "Harry Brainiac");

    submitted = false;

    onSubmit() { this.submitted = true; }

    get diagnostic() {return JSON.stringify(this.model);}
}
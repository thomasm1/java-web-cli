import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BasicNG';
  hello :string = "Hello World!";
  website :string = "https://www.espn.com/";

  showParagraph :boolean = false;
  superSmashCharacters :Array<string> = ["Falco", "Link", "Ness", "Mario", "Kirby"];
  character :string;

  money :number = 20;
  coins :number;

  saySomething() {
    this.hello = (this.hello == "Goodbye World!") ? "Hello World!" : "Goodbye World!";
  }

  changeWebsite() {
    this.website = (this.website == "https://www.espn.com/") ? "https://www.google.com/" : "https://www.espn.com/";
  }

  showText() {
    this.showParagraph = !(this.showParagraph);
  }

  addCharacter() {
    this.superSmashCharacters.push(this.character);
    this.clearText();
  }

  clearAll() {
    this.superSmashCharacters = [];
  }

  clearText() {
    this.character = '';
  }

  addMoney() {
    this.money += this.coins;
  }

}

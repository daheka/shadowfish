import {Component} from "@angular/core";
import {News} from "../../models/news.model";

@Component({
  selector: 'news',
  templateUrl: 'news.component.html',
})

export class NewsComponent {
  private news: News = new News('New Post', "Subtitle post", null, "Hello this is a post to see how a post would look like", "Wednesday 17th October 2012 at 08:56");

  constructor() {

  }
}

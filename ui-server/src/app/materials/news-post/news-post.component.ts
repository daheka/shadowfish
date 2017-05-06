import {Component, Input} from '@angular/core';


@Component({
  selector: 'news-post',
  templateUrl: 'news-post.component.html',
  styleUrls: ['news-post.component.css'],
})

export class NewsPostComponent {
  @Input() title: string;
  @Input() subtitle: string;
  @Input() img: string;
  @Input() content: string;
  @Input() date:string;
}

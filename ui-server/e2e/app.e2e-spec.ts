import { NewUiServerPage } from './app.po';

describe('new-ui-server App', () => {
  let page: NewUiServerPage;

  beforeEach(() => {
    page = new NewUiServerPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

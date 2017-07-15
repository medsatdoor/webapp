import { MedEasyPage } from './app.po';

describe('med-easy App', function() {
  let page: MedEasyPage;

  beforeEach(() => {
    page = new MedEasyPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

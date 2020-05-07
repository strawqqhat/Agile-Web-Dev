describe('add todo', function () {
  let page;

  before (async function () {
    page = await browser.newPage();
    await page.goto('http://127.0.0.1:7001/');
  });

  after (async function () {
    await page.close();
  });

  it('should have correct title', async function() {
      expect(await page.title()).to.eql('Koa • Todo');
  })
  it('should new todo correctly', async function() {
    await page.click('#new-todo', {delay: 500});
    await page.type('#new-todo', 'new todo item', {delay: 50});
    await page.keyboard.press("Enter");
    let todoList = await page.waitFor('#todo-list');
    const expectInputContent = await page.evaluate(todoList => todoList.lastChild.querySelector('label').textContent, todoList);
    expect(expectInputContent).to.eql('new todo item');
  }) 
});

describe('delete todo', function () {
  let page;

  before (async function () {
    page = await browser.newPage();
    await page.goto('http://127.0.0.1:7001/');
  });
  after (async function () {
    await page.close();
  });

 it('should delete todo correctly',async function(){
    const length1 = await page.$$eval('#todo-list li',list=> list.length);
    console.log(length1)
    await page.evaluate(()=> {
    document.querySelector('.destroy').click()
  });
    await page.waitFor('#todo-list');
    const length2 = await page.$$eval('#todo-list li',list=>list.length);
    console.log(length2)
    expect(length2).to.eql(length1-1);
 }) 
});

describe('get todo', function () {
  let page;

  before (async function () {
    page = await browser.newPage();
    await page.goto('http://127.0.0.1:7001/');
  });

  after (async function () {
    await page.close();
  });

  it('should get todo correctly', async function() {
    let todoList = await page.$$('#todo-list li');
    expect(todoList).to.have.property('length');
    console.log(todoList.length);
  })
});

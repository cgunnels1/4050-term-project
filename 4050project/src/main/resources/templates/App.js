import React from 'react';
import './App.css';
import { Dropdown, DropdownToggle, DropdownMenu, DropdownItem, Card, CardImg, CardText, CardBody, CardTitle, CardSubtitle, Button, InputGroup, InputGroupAddon, InputGroupText, Input, Form, FormGroup, Label,  FormText, Container, Row, Col  } from 'reactstrap';


const inventory = [
  {
    "title": "Cat In The Hat",
    "author" : "Dr. Seuss",
    "imgPath": './images/cat_in_the_hat.jpeg',
    "description": "A funny story about a cat with a hat or something like that. It is the best book I've ever read honestly.",
    "price": 10.99
    
  },
  {
    "title": "Green Eggs and Ham",
    "author" : "Dr. Seuss",
    "imgPath": "./images/green_eggs_and_ham.png",
    "description": "If you like eggs and you like ham, you will absolutely lose your mind about how good this book is I promise.",
    "price": 9.99
  },
  {
    "title": "Oh the Places You'll Go",
    "author" : "Dr. Seuss",
    "imgPath": "./images/oh_the_places_youll_go.png",
    "description": "This book is definitely the worst Dr. Seuss book in my opinion. There are no character arcs and the main villain isn't very compelling.",
    "price": 25.99
  },
  {
    "title": "One Fish Two Fish Red Fish Blue Fish",
    "author" : "Dr. Seuss",
    "imgPath": "./images/one_fish_two_fish_red_fish_blue_fish.jpeg",
    "description": "If you have a fear of fish stay far far away from this book. It is a thrilling drama about fish with an unexpected twist at the end.",
    "price": 1.99
  }
];

class BookStore extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      currentBook: null,
      currentPage: 0,
      accountMenu: false,
      cart: [],
      managedBooks: inventory
    }
  }

  handleBookClick = (index) => {
    this.setState({
      currentBook: index,
      currentPage: 1
    })
  }

  addToCart(index) {
    var cart = this.state.cart;
    cart.push(index);
    this.setState({
      cart: cart,
      currentPage: 0
    })
  }

  handleRemoveFromCart(index) {
    var cart = this.state.cart;
    cart.splice(index,1);
    this.setState({
      cart: cart
    })
  }

  renderCart() {
    var total = 0.0;
    return (
      <div style={{width: "80%", marginLeft: "10%", backgroundColor: "wheat", textAlign: "center"}}> 
        <h1>My Cart</h1>
        <Container >
          {this.state.cart.map((book, index) => {
            total = total + inventory[book]["price"];
            return (
              <Row style={{width:"90%", outline: "2px solid"}}>
                <Col style={{outline: "2px solid"}}>{inventory[book]["title"]}</Col>
                <Col style={{outline: "2px solid"}}>{inventory[book]["author"]}</Col>
                <Col style={{outline: "2px solid"}}>${inventory[book]["price"]}</Col>
                <Button onClick={() => this.handleRemoveFromCart(index)}>Remove</Button>
              </Row>
            )
          })}
        </Container>
        <h3>Your total is ${total}.</h3>
        <Button onClick={() => this.handleChangeScreens(7)}>Place Order</Button>
      </div>
    );
  }

  renderConfirmOrderInfo() {
    return (
        <div style={{width: "50%", marginLeft: "25%"}}>
      <h1>Confirm Payment Info and Address</h1>
      <FormGroup>
        <Label for="address">Address</Label>
        <Input type="text" name="address" id="address" placeholder="123 House St" />
      </FormGroup>
      <FormGroup>
        <Label for="city">City</Label>
        <Input type="text" name="city" id="city" placeholder="Athens" />
      </FormGroup>
      <FormGroup>
        <Label for="zipCode">Zip Code</Label>
        <Input type="text" name="zipCode" id="zipCode" placeholder="30601" />
      </FormGroup>
      <FormGroup>
        <Label for="creditCard">Credit Card Number</Label>
        <Input type="text" name="creditCard" id="creditCard" placeholder="1234123412341234" />
      </FormGroup>
      <FormGroup>
        <Label for="expDate">Expiration Date MM/YYYY</Label>
        <Input type="text" name="expDate" id="expDate" placeholder="01/2050" />
      </FormGroup>
      <FormGroup>
        <Label for="cvv">CVV</Label>
        <Input type="password" name="cvv" id="cvv" placeholder="111" />
      </FormGroup>
      <Button style={{height: "60px"}} onClick={() => this.handleChangeScreens(8)}>Confirm Order</Button>
    </div>
    );
  }

  showBookDetails() {
    return (
      <div>
        <Card style={{width: "35%", margin: "20px", marginLeft: "32.5%", backgroundColor: "wheat", padding: "10px"}}>
          <h1>{inventory[this.state.currentBook]["title"]}</h1>
          <CardImg top style={{width: "200px"}} src={require(`${inventory[this.state.currentBook]["imgPath"]}`)} alt="Card image cap" />
          <CardBody>
          <CardSubtitle>{inventory[this.state.currentBook]["author"]}</CardSubtitle>
          <CardText>{inventory[this.state.currentBook]["description"]}</CardText>
          <CardText style={{color: "red"}}>${inventory[this.state.currentBook]["price"]}</CardText>
          <Button style={{height: "60px", marginLeft: "35%"}} onClick={() => this.addToCart(this.state.currentBook)}>Add To Cart</Button>
          </CardBody>
        </Card>
      </div>
    );
  }

  handleGoToFeatured = () => {
    this.setState({
      currentPage: 0
    })
  }

  handleGoToCreateAccount = () => {
    this.setState({
      currentPage: 2
    })
  }

  renderBooks() {
    return (
      <div>
        <h1 style={{marginLeft: "40%"}}>Featured Books</h1>
        {inventory.map((book, index) => {
          return (
            <div>
            <Card onClick={() => this.handleBookClick(index)} style={{width: "35%", margin: "20px", marginLeft: "32.5%", backgroundColor: "wheat", padding: "10px"}}>
              <h1>{inventory[index]["title"]}</h1>
              <CardImg top style={{width: "200px"}} src={require(`${inventory[index]["imgPath"]}`)} alt="Card image cap" />
              <CardBody>
              <CardSubtitle>{inventory[index]["author"]}</CardSubtitle>
              <CardText>{inventory[index]["description"]}</CardText>
              </CardBody>
            </Card>
      </div>
          )
        })}
      </div>
      
    );
  }

  renderCreateAccount() {
    return (
      <div style={{width: "50%", marginLeft: "25%", textAlign: "center"}}>
      <h1>Create New Account</h1>
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>*</InputGroupText>
        </InputGroupAddon>
        <Input placeholder="First Name" />
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>*</InputGroupText>
        </InputGroupAddon>
        <Input placeholder="Last Name" />
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>*</InputGroupText>
        </InputGroupAddon>
        <Input placeholder="Email" />
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>*</InputGroupText>
        </InputGroupAddon>
        <Input placeholder="Username" />
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>*</InputGroupText>
        </InputGroupAddon>
        <Input type="password" placeholder="Password" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input placeholder="Address" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input placeholder="City" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input placeholder="Zip Code" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input placeholder="Credit Card Number" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input placeholder="Expiration Date as MM/YYYY" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input type="password" placeholder="CVV" />
      </InputGroup>
      <br />
      <Button style={{height: "60px"}} onClick={() => this.handleChangeScreens(3)}>Create Account</Button>
      
    </div>
    );
  }

  renderAcountCreatedConfirmation() {
    return (
      <div style={{marginTop: "50px", width: "40%", height: "200px", textAlign: "center", marginLeft: "30%", borderRadius: "10px"}}className="createAccount">
        <h1>Email confirmation sent!</h1>
        <h3>Please check your email for a link to finish creating your account.</h3>
        <button onClick={() => this.handleChangeScreens(0)}>OK</button>
      </div>
    )
  }

  handleChangeScreens(num) {
    this.setState({
      currentPage: num
    })
  }

  renderLogin() {
    return (
      <div style={{width: "50%", marginLeft: "25%", textAlign: "center", marginTop: "60px"}}>
        <h1>Enter Login Info:</h1>
        <InputGroup>
        <Input placeholder="Username or Email" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input type="password" placeholder="Password" />
      </InputGroup>
      <br />
      <Button style={{height: "60px"}} onClick={() => this.handleChangeScreens(0)}>Login</Button>

      </div>
    );
  }

  toggleAccountMenu = () => {
    var accountMenu = !this.state.accountMenu;
    this.setState({
      accountMenu: accountMenu
    })
  }

  renderHeading() {
    return (
      <ul style={{marginBottom: "0"}}>
        <li><Button onClick={() => this.handleChangeScreens(0)}>Featured</Button></li>
        <li><Button onClick={() => this.handleChangeScreens(6)}>My Cart</Button></li>
        <li>
        <Dropdown style={{display: "inline"}} isOpen={this.state.accountMenu} toggle={this.toggleAccountMenu}>
          <DropdownToggle style={{width: "120px"}} caret>
            Account
          </DropdownToggle>
          <DropdownMenu>
            <DropdownItem onClick={() => {this.handleChangeScreens(4)}}>Login</DropdownItem>
            <DropdownItem onClick={() => {this.handleChangeScreens(2)}}>Create Account</DropdownItem>
            <DropdownItem onClick={() => {this.handleChangeScreens(5)}}>Edit Account</DropdownItem>
            <DropdownItem onClick={() => {this.handleChangeScreens(10)}} >Order History</DropdownItem>
            <DropdownItem onClick={() => {this.handleChangeScreens(9)}} style={{color: "red"}}>Admin Mode</DropdownItem>
          </DropdownMenu>
        </Dropdown>

        </li>
      </ul>
    );
  }

  renderSearchBar() {
    return (
      <div style={{backgroundColor: "olive"}}>
        <InputGroup style={{width: "40%", marginLeft: "30%"}}>
          <InputGroupAddon addonType="prepend">
            <Input style={{height: "50px", width: "100px"}} type="select" name="searchSetting" id="searchSetting">
              <option>Title</option>
              <option>Author</option>
              <option>Genre</option>
            </Input>
          </InputGroupAddon>
            <Input style={{height: "50px"}} placeholder="look for a book"/>
          <InputGroupAddon addonType="append"><Button>Search</Button></InputGroupAddon>
        </InputGroup>
      </div>
    );
  }

  renderEditAccount() {
    return (
        <div style={{width: "50%", marginLeft: "25%"}}>
      <h1>Edit Account Info</h1>
      <FormGroup>
        <Label for="firstName">First Name</Label>
        <Input type="text" name="first name" id="firstName" placeholder="Zach" />
      </FormGroup>
      <FormGroup>
        <Label for="lastName">Last Name</Label>
        <Input type="text" name="last name" id="lastName" placeholder="Rustick" />
      </FormGroup>
      <FormGroup>
        <Label for="email">Email</Label>
        <Input type="text" name="email" id="email" placeholder="ZackyBoy7@example.com" />
      </FormGroup>
      <FormGroup>
        <Label for="username">Username</Label>
        <Input type="text" name="username" id="username" placeholder="ZackyBoy7" />
      </FormGroup>
      <FormGroup>
        <Label for="pw">Password</Label>
        <Input type="password" name="pw" id="pw" placeholder="password" />
      </FormGroup>
      <FormGroup>
        <Label for="address">Address</Label>
        <Input type="text" name="address" id="address" placeholder="123 House St" />
      </FormGroup>
      <FormGroup>
        <Label for="city">City</Label>
        <Input type="text" name="city" id="city" placeholder="Athens" />
      </FormGroup>
      <FormGroup>
        <Label for="zipCode">Zip Code</Label>
        <Input type="text" name="zipCode" id="zipCode" placeholder="30601" />
      </FormGroup>
      <FormGroup>
        <Label for="creditCard">Credit Card Number</Label>
        <Input type="text" name="creditCard" id="creditCard" placeholder="1234123412341234" />
      </FormGroup>
      <FormGroup>
        <Label for="expDate">Expiration Date MM/YYYY</Label>
        <Input type="text" name="expDate" id="expDate" placeholder="01/2050" />
      </FormGroup>
      <FormGroup>
        <Label for="cvv">CVV</Label>
        <Input type="password" name="cvv" id="cvv" placeholder="111" />
      </FormGroup>
      <Button style={{height: "60px"}} onClick={() => this.handleChangeScreens(0)}>Confirm Changes</Button>
    </div>
    );
  }

  renderOrderConfirmation() {
    return (
      <div style={{marginTop: "50px", width: "40%", height: "200px", textAlign: "center", marginLeft: "30%", borderRadius: "10px"}}className="createAccount">
        <h1>Your order has been placed!</h1>
        <h3>Please check your email for a link regarding your package delivery date.</h3>
        <button onClick={() => this.handleChangeScreens(0)}>OK</button>
      </div>
    )
  }

  removeManagedBook(index) {
    var managedBooks = this.state.managedBooks;
    managedBooks.splice(index,1);
    this.setState({
      managedBooks: managedBooks
    })
  }

  renderAdminView() {
    return (
      <div style={{marginLeft: "10%", width: "80%", height:"1000px", marginTop: "20px", backgroundColor: "olive", textAlign: "center"}}>
        <Button style={{height: "60px"}}>Manage Books</Button>
        <Button style={{height: "60px"}}>Manage Accounts</Button>
        <Button style={{height: "60px"}}>Manage Promotions</Button>

        <h1>Available Books</h1>
        <Container >
          {this.state.managedBooks.map((book, index) => {
            return (
              <Row style={{width:"90%", outline: "2px solid"}}>
                <Col style={{outline: "2px solid"}}>{this.state.managedBooks[index]["title"]}</Col>
                <Col style={{outline: "2px solid"}}>{this.state.managedBooks[index]["author"]}</Col>
                <Col style={{outline: "2px solid"}}>${this.state.managedBooks[index]["price"]}</Col>
                <Col style={{outline: "2px solid"}}>{this.state.managedBooks[index]["imgPath"]}</Col>
                <Button onClick={() => this.removeManagedBook(index)}>Delete</Button>
              </Row>
            )
          })}
        </Container>
        <Button>Add Book</Button>
      </div>
    )
  }

  renderOrderHistory() {
    return (
      <div style={{marginLeft: "10%", width: "80%", height:"1000px", marginTop: "20px", backgroundColor: "olive", textAlign: "center"}}>
        <h1>Order History</h1>
        <Container >
          {this.state.managedBooks.map((book, index) => {
            return (
              <Row style={{width:"90%", outline: "2px solid"}}>
                <Col style={{outline: "2px solid"}}>{this.state.managedBooks[index]["title"]}</Col>
                <Col style={{outline: "2px solid"}}>{this.state.managedBooks[index]["author"]}</Col>
                <Col style={{outline: "2px solid"}}>${this.state.managedBooks[index]["price"]}</Col>
                <Col style={{outline: "2px solid"}}>Oct 31, 2020</Col>
                <Button onClick={() => this.removeManagedBook(index)}>Reorder</Button>
              </Row>
            )
          })}
        </Container>
      </div>
    )
  }

  render() {
    return(
      <div >
        {this.renderHeading()}
        {(this.state.currentPage===0 || this.state.currentPage===1) && this.renderSearchBar()}
        {this.state.currentPage===0 && this.renderBooks()}
        {this.state.currentPage===1 && this.showBookDetails()}
        {this.state.currentPage===2 && this.renderCreateAccount()}
        {this.state.currentPage===3 && this.renderAcountCreatedConfirmation()}
        {this.state.currentPage===4 && this.renderLogin()}
        {this.state.currentPage===5 && this.renderEditAccount()}
        {this.state.currentPage===6 && this.renderCart()}
        {this.state.currentPage===7 && this.renderConfirmOrderInfo()}
        {this.state.currentPage===8 && this.renderOrderConfirmation()}
        {this.state.currentPage===9 && this.renderAdminView()}
        {this.state.currentPage===10 && this.renderOrderHistory()}
      </div>
    );
  }

  
}

export default BookStore;

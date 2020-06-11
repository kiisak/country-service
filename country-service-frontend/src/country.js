import React from "react";
import axios from 'axios'

class Country extends React.Component {
    constructor(props) {
        super(props)
        this.state = {findDone: false, value  : '', data: '', foundCountry: false};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

  getCountry(name) {
    axios.get('http://localhost:8080/countries/name/' + name)
      .then(response => {
          this.setState({
            data: response.data,
            findDone: true,
            foundCountry: true
          });
      })
      .catch(error => {
        this.setState({
          findDone: true,
          foundCountry: false
        });
      });
  }

  handleChange(event) {
    this.setState({value: event.target.value, findDone: false
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    this.getCountry(this.state.value);
  }

  findResult() {
    if (this.state.findDone) {
      if (this.state.foundCountry) {
        return ( 
          <div>
                <h3>Found country</h3>
                <table>
                <thead>
                    <tr>
                      <th>Name</th>
                      <th>Country code</th>
                      <th>Capital</th>
                      <th>Population</th>
                      <th>Flag file url</th>
                    </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>{ this.state.data[0].name }</td>
                    <td>{ this.state.data[0].country_code }</td>
                    <td>{ this.state.data[0].capital }</td>
                    <td>{ this.state.data[0].population }</td>
                    <td>{ this.state.data[0].flag_file_url }</td>
                  </tr>
                </tbody>
                </table>
            </div>
        )
      } else {
        return ( 
          <div>
            <h3>Not found country: {this.state.value}</h3>
          </div>
        )
      }
    } else {
        /*return (
          null
        )*/
    }
  }

  render() {
    var results = this.findResult();
    return (
        <form onSubmit={this.handleSubmit}>
            <input type="text" value={this.state.inputValue} onChange={this.handleChange}/>
            <button onClick={this.onSubmit}>Find</button>
            <hr></hr>
            {results}
      </form>
    );
  }
}

export default Country;
import React from "react";
import axios from 'axios'

class Countries extends React.Component {
    
    constructor(props) {
        super(props)
        this.state = {value: '', data: ''};
    }

    componentDidMount() {
        this.getCountries();
    }
    
    getCountries() {
        axios.get('http://localhost:8080/countries').then(response => {
            this.setState({
                data: response.data
            });
          })
    }
    
    
    renderRow(country) {
        return <tr>
            <td>{ country.name }</td>
            <td>{ country.country_code }</td>
        </tr>
    }
    
    render() {
        return (
            <div>
                { this.state.data !== '' ?
                <div>
                    <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Country code</th>
                        </tr>
                    </thead>
                    <tbody>
                        { this.state.data.map(this.renderRow) }
                    </tbody>
                    </table>
                </div> : null
                }
            </div>
        );
    }
}

export default Countries;
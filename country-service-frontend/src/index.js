import React from "react";
import ReactDOM from "react-dom";
import {
  Route,
  NavLink,
  BrowserRouter as Router,
  Switch
} from "react-router-dom";
import Countries from "./countries";
import Country from "./country";

const routing = (
  <Router>
    <div>
      <ul>
        <li>
          <NavLink activeClassName="active" to="/countries">
            List all countries
          </NavLink>
        </li>
        <li>
          <NavLink activeClassName="active" to="/country">
            Find country by name
          </NavLink>
        </li>
      </ul>
      <hr />
      <Switch>
        <Route exact path="/" component={Countries} />
        <Route path="/countries" component={Countries} />
        <Route path="/country" component={Country} />
      </Switch>
    </div>
  </Router>
);

ReactDOM.render(routing, document.getElementById("root"));

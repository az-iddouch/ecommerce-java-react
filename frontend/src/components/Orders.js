import React, { useEffect, useState } from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import axios from 'axios';
import { CircularProgress } from '@material-ui/core';

const StyledTableCell = withStyles((theme) => ({
  head: {
    backgroundColor: '#777',
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

function preventDefault(event) {
  event.preventDefault();
}

function getNumberOfDays(endDate, startDate) {
  const diffTime = Math.abs(endDate - startDate);
  return Math.ceil(diffTime / (1000 * 60 * 60 * 24)) + 1;
}

const useStyles = makeStyles((theme) => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
}));

export default function Orders() {
  const classes = useStyles();
  const [properties, setProperties] = useState(null);

  useEffect(() => {
    fetchProperties();
  }, []);

  async function fetchProperties() {
    try {
      const res = await axios.get('http://localhost:9091/api/dashboard/');
      setProperties(res.data);
    } catch (err) {
      console.log(err);
    }
  }

  if (properties === null) {
    return <CircularProgress className="loading" />;
  }

  function formatDate(d) {
    const months = [
      'January',
      'February',
      'March',
      'April',
      'May',
      'June',
      'July',
      'August',
      'September',
      'October',
      'November',
      'December',
    ];

    const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    const year = d.getFullYear();
    const date = d.getDate();
    const monthName = months[d.getMonth()];
    const dayName = days[d.getDay()];
    return `${dayName}, ${date} ${monthName} ${year}`;
  }

  return (
    <React.Fragment>
      <h2>Reservations</h2>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Start Date</TableCell>
            <TableCell>End Date</TableCell>
            <TableCell>By</TableCell>
            <TableCell>Phone number</TableCell>
            <TableCell>Number of People</TableCell>
            <TableCell>Total</TableCell>
            <TableCell align="right">Status</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {properties.map((property) => {
            return (
              <>
                <TableRow>
                  <StyledTableCell style={{ fontWeight: 800 }}>
                    [{property.typeProperty.type}] {property.city.nameCity}
                  </StyledTableCell>
                  <StyledTableCell align="right"></StyledTableCell>
                  <StyledTableCell align="right"></StyledTableCell>
                  <StyledTableCell align="right"></StyledTableCell>
                  <StyledTableCell align="right"></StyledTableCell>
                  <StyledTableCell align="right"></StyledTableCell>
                  <StyledTableCell align="right"></StyledTableCell>
                </TableRow>

                {property.reservations.map((reservation) => {
                  return (
                    <TableRow key={reservation.id}>
                      <TableCell>
                        {formatDate(new Date(reservation.dateStart))}
                      </TableCell>
                      <TableCell>
                        {formatDate(new Date(reservation.dateEnd))}
                      </TableCell>
                      <TableCell>
                        {reservation.user.firstName} {reservation.user.lastName}
                      </TableCell>
                      <TableCell>{reservation.user.phoneNumber1}</TableCell>
                      <TableCell>{reservation.numberPersons}</TableCell>
                      <TableCell>
                        {property.price *
                          getNumberOfDays(
                            new Date(reservation.dateStart),
                            new Date(reservation.dateEnd)
                          )}
                      </TableCell>
                      <TableCell align="right">{reservation.status}</TableCell>
                    </TableRow>
                  );
                })}
              </>
            );
          })}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        <Link color="primary" href="#" onClick={preventDefault}>
          See more orders
        </Link>
      </div>
    </React.Fragment>
  );
}

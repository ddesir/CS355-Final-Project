#!/usr/bin/env python3

import sqlite3
import pandas as pd
import random

''' Script to open connection to database file, add new column, and populate
		column with random integer for rating. '''

conn = sqlite3.connect('games.db')
c = conn.cursor()

tables = c.execute('SELECT name FROM sqlite_master WHERE type=\'table\';').fetchall()
game_list = c.execute('SELECT * FROM Listings;').fetchall()
devs_list = c.execute('SELECT * FROM DevGames;').fetchall()

print (tables)
print ('')

# Insert 'Rating' column to the 'Listing' table
# c.execute ('ALTER TABLE Listings ADD COLUMN \'DevID\' \'integer\'')

# Update 'Rating' column with random integer from 0 to 5
# for i in devs_list:
#	dev_id = c.execute(f'SELECT DevID FROM DevGames WHERE GameID={i + 1};')
#	c.execute (f'UPDATE Listings SET DevID={i[0]} WHERE GameID={i[1]}')
	
query = 'SELECT * FROM Listings;'
print (pd.read_sql_query(query, conn))

conn.commit()
conn.close()
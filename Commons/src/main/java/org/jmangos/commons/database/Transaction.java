/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.jmangos.commons.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc

public class Transaction
{
	
	/** Logger for transactions. */
	private static final Logger	log	= Logger.getLogger(Transaction.class);

	/** Connection that is allocated for this transaction. */
	private Connection			connection;

	/**
	 * Package private constructor, should be instantiated via.
	 *
	 * @param con Connection that will be used for this transaction
	 * @throws SQLException the sQL exception
	 * {@link org.jmangos.commons.database.DB#beginTransaction()} class
	 */
	Transaction(Connection con) throws SQLException
	{
		this.connection = con;
		connection.setAutoCommit(false);
	}

	/**
	 * Adds Insert / Update Query to the transaction.
	 *
	 * @param sql SQL string
	 * @throws SQLException if something went wrong
	 */
	public void insertUpdate(String sql) throws SQLException
	{
		insertUpdate(sql, null);
	}

	/**
	 * Adds Insert / Update Query to this transaction. Utilizes IUSth for Batching and Query Editing. MUST MANUALLY
	 * EXECUTE QUERY / BATACH IN IUSth (No need to close Statement after execution)
	 * 
	 * @param sql
	 *            Sql query
	 * @param iusth
	 *            query helper
	 * @throws SQLException
	 *             if something went wrong
	 */
	public void insertUpdate(String sql, IUStH iusth) throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement(sql);
		if(iusth != null)
		{
			iusth.handleInsertUpdate(statement);
		}
		else
		{
			statement.executeUpdate();
		}
	}

	/**
	 * Creates new savepoint.
	 *
	 * @param name name of savepoint
	 * @return created savepoint
	 * @throws SQLException if can't create save point
	 */
	public Savepoint setSavepoint(String name) throws SQLException
	{
		return connection.setSavepoint(name);
	}

	/**
	 * Releases savepoint of transaction.
	 *
	 * @param savepoint savepoint to release
	 * @throws SQLException if something went wrong
	 */
	public void releaseSavepoint(Savepoint savepoint) throws SQLException
	{
		connection.releaseSavepoint(savepoint);
	}

	/**
	 * Commits transaction.
	 *
	 * @throws SQLException if something is wrong with transaction
	 */
	public void commit() throws SQLException
	{
		commit(null);
	}

	/**
	 * Commits transaction. If rollBackToOnError is null - whole transaction will be rolledback
	 * 
	 * @param rollBackToOnError
	 *            savepoint that should be used to rollback
	 * @throws SQLException
	 *             if something went wrongF
	 */
	public void commit(Savepoint rollBackToOnError) throws SQLException
	{

		try
		{
			connection.commit();
		}
		catch(SQLException e)
		{
			log.warn("Error while commiting transaction", e);

			try
			{
				if(rollBackToOnError != null)
				{
					connection.rollback(rollBackToOnError);
				}
				else
				{
					connection.rollback();
				}
			}
			catch(SQLException e1)
			{
				log.error("Can't rollback transaction", e1);
			}
		}

		connection.setAutoCommit(true);
		connection.close();
	}
}
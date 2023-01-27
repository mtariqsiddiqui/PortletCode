package com.sadad.portal.beans;

public enum BatchFilesTypeEnum
{
	ACONRQ, // Account Upload Confirmation
	BCONRQ, // Bill Upload Confirmation
	BLRCRQ, // Biller Payment Reconciliation
	BLRRRQ, // Biller Refund Reconciliation Report
	PCONRQ, // Payment Upload Confirmation
	BKRCRQ, // Bank Payment Reconciliation
	BKRRRQ, // Bank Refund Reconciliation
	BCUTRQ, // Payment Cutoff
	XADRRQ, // Refund Intrabank 1
	XACRRQ, // Refund Intrabank 2
	XADDRQ, // Payment Intrabank Instruction File
	BSPLRQ, // Biller Payment SPL
	PNUPRQ, // Payment Batch Notification
	RNOCRQ, // Refund Bulk Notification
	RNUBRQ, // Refund Batch Notification
	RCUTRQ, // Refund Cutoff
	RCONRQ; // Refund Upload Confirmation
}
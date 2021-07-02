package com.abinanth.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abinanth.model.PaymentModel;
import com.abinanth.service.BillGeneratorService;

@Repository
public class PaymentRepository {
	@Autowired
	PaymentModel paymentModel;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	BillGeneratorService billService;
	private static final String SQL = "INSERT INTO payment(recidency_no,amount,status,"
			+ "due_date,fine_amount,total_amount) VALUES(?,?,?,?,?,?)";
	private final static String SQL1 = "select*from payment";
	private final static String SQL2 = "select bill_details.recidency_type ,\r\n"
			+ "payment.payment_id, payment.recidency_no, payment.status,payment.due_date,payment.paid_date, payment.total_amount\r\n"
			+ "from bill_details inner join payment on bill_details.recidency_no=payment.recidency_no and bill_details.recidency_type ILIKE ? or payment.status=?";

	public PaymentModel save(PaymentModel addBill) {

		LocalDate dueDate = billService.getDueDate();
		addBill.setDueDate(dueDate);
		addBill.setStatus("PENDING");
		addBill.setFineAmount(0.0);
		jdbcTemplate.update(SQL, addBill.getRecidenyNo(), addBill.getAmount(), addBill.getStatus(),
				addBill.getDueDate(), addBill.getFineAmount(), addBill.getAmount());
		return addBill;
	}

	public List<PaymentModel> findAll() {
//		LocalDate localDate = null;
//		Date date = null;
		return jdbcTemplate.query(SQL1, (rs, rowNo) -> {

			PaymentModel paymentModel = new PaymentModel();
			paymentModel.setPaymentId(rs.getInt("payment_id"));
			paymentModel.setRecidenyNo(rs.getInt("recidency_no"));
			paymentModel.setAmount(rs.getInt("amount"));
			Date paidDate = rs.getDate("paid_date");
			if (paidDate != null) {
				paymentModel.setPaidDate(paidDate.toLocalDate());
			}
			paymentModel.setStatus(rs.getString("status"));
			Date dueDate = rs.getDate("due_date");
			if (dueDate != null) {
				paymentModel.setPaidDate(dueDate.toLocalDate());
			}
			paymentModel.setTotalAmount(rs.getDouble("total_amount"));

			return paymentModel;
//
//					new PaymentModel(,,
//
//						, rs.getInt("payment_id"), rs.getDate("due_date"),
//						rs.getDouble("fine_amount"), rs.getDate("paid_date"), rs.getDouble("total_amount")));
//
		});

	}

//	public List<PaymentModel> findByRecidencyAndStatus(String word) {
//		return jdbcTemplate.query(SQL2, (rs, rowNo) -> {
//
//			SearchModel search = new SearchModel();
//			search.setPaymentId(rs.getInt("payment_id"));
//			search.setRecidenyNo(rs.getInt("recidency_no"));
//			search.setRecidencyType(rs.getString("recidency_type"));
//			search.setAmount(rs.getInt("amount"));
//			Date paidDate = rs.getDate("paid_date");
//			if (paidDate != null) {
//				search.setPaidDate(paidDate.toLocalDate());
//			}
//			search.setStatus(rs.getString("status"));
//			Date dueDate = rs.getDate("due_date");
//			if (dueDate != null) {
//				search.setPaidDate(dueDate.toLocalDate());
//			}
//			search.setTotalAmount(rs.getDouble("total_amount"));
//		});
}

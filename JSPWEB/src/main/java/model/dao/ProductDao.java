package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import controller.board.list;
import model.dto.CartDto;
import model.dto.PcategoryDto;
import model.dto.ProductDto;
import model.dto.StockDto;

public class ProductDao extends Dao {
	
	// 1. 카테고리 등록 [ C ] 
	public boolean setPcategory( String pcname ) {
		String sql = "insert into pcategory( pcname ) values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pcname );
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	} // setPcategory e
	
	// 2. 카테고리 출력 [ R ] 
	public ArrayList< PcategoryDto > getPcategory() {
		ArrayList< PcategoryDto > list = new ArrayList<>();
		
		String sql = "select * from pcategory";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				PcategoryDto dto = new PcategoryDto(
						rs.getInt(1), rs.getString(2));				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // getPcategory e
	
	// 3. 제품 등록 [ C ] 
	public boolean setProduct( ProductDto dto ) {
		String sql = "insert into product( pname, pcomment, pprice, pdiscount, pimg, pcno) values(?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setFloat(4, dto.getPdiscount());
			ps.setString(5, dto.getPimg());
			ps.setInt(6, dto.getPcno());
			ps.executeUpdate();
			return true;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	} // setProduct e

	// 4. 제품 출력 [ R ] 
	public ArrayList< ProductDto > getProductlist( String option ) {
		ArrayList< ProductDto > list = new ArrayList<>();
		
		String sql = null;
		if ( option.equals("all") ) {
			// 1. 조건없이 모든 제품 출력
			sql = "select * from product";
		}else if ( option.equals("pactive1") ) {
			// 2. [ 판매중 ] 상태만 모든 제품 출력
			sql = "select * from product where pactive = 1 order by pdate desc";
		}
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				ProductDto dto = new ProductDto(
						rs.getInt(1),	rs.getString(2),
						rs.getString(3),rs.getInt(4),
						rs.getFloat(5), rs.getByte(6),
						rs.getString(7),rs.getString(8),
						rs.getInt(9));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // getProductlist e
	
	
	
	// 5. 제품 삭제
	public boolean deleteproduct( int pno ) {
		String sql = "delete from product where pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			// 삭제시 삭제된 레코드 수로 삭제 성공 유무 판단
			int count = ps.executeUpdate();
			if( count == 1 ) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // deleteproduct e
	
	
	
	// 6. 제품 개별 출력
	public ProductDto getProduct( int pno ) {
		String sql ="select * from product where pno =" +pno;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				ProductDto dto = new ProductDto(
					rs.getInt(1),	rs.getString(2),
					rs.getString(3),rs.getInt(4),
					rs.getFloat(5), rs.getByte(6),
					rs.getString(7),rs.getString(8),
					rs.getInt(9));
					return dto;
			}
		}	
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	} // getProduct e
	
	
	// 7. 제품 수정
	public boolean updateproduct( ProductDto dto ) {
		String sql = "update product set pname = ?, pcomment = ?, pprice = ?, pdiscount = ?, pactive = ?, pimg = ?, pcno = ? where pno = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setFloat(4, dto.getPdiscount());
			ps.setByte(5, dto.getPactive());
			ps.setString(6, dto.getPimg());
			ps.setInt(7, dto.getPcno());
			ps.setInt(8, dto.getPno());
			ps.executeUpdate();
			return true;
					
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	} // setProduct e
	
	
	// 8. 재고 등록
	public boolean setstock( String psize, int pno, String pcolor, int pstock ) {
		String sql = "insert into productsize( psize, pno ) value ( ? , ? )";

		// 1. 사이즈 등록
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS ); // 실행된 insert 의 실행 결과를 가져옴 RETURN_GENERATED_KEYS
			ps.setString(1, psize);
			ps.setInt(2, pno);
			ps.executeUpdate();
			
			// * 해당 sql에서 insert된 pk 값 가져오기
			// ps = con.prepareStatement(sql, statement);
					// ! : Statement [ java.sql 패키지 ] 
			rs = ps.getGeneratedKeys();	 // 방금 생성된 pk값 호출
			
			if ( rs.next() ) {
				int psno = rs.getInt(1); // pk 호출
				
				// 2. 색상 재고 등록
				sql = "insert into productstock( pcolor, pstock, psno ) values ( ?, ?, ? )";
				ps = con.prepareStatement(sql);
				ps.setString(1, pcolor);
				ps.setInt(2, pstock);
				ps.setInt(3, psno); // 첫번째 sql 실행결과로 생성된 pk 값
				ps.executeUpdate();
				return true;
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	} // setstock e
	
	
	// 9. 제품별 재고 출력
	public ArrayList< StockDto > getstock( int pno ) {
		
		ArrayList<StockDto> list = new ArrayList<>();
		String sql = "select ps.psno, ps.psize, pst.pstno, pst.pcolor, pst.pstock\r\n"
				+ "from productsize as ps, productstock as pst\r\n"
				+ "where ps.psno = pst.psno and ps.pno = "+ pno + "\r\n"
				+ "order by ps.psize desc;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				StockDto dto = new StockDto(
						rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4), rs.getInt(5));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // getstock e
	
	
	// 10. 해당 제품에 찜하기
	public int setplike( int pno, int mno ) {
		String sql = "select * from plike where pno = ? and mno = ?"; // 검색 [ 해당 제품의 찜하기 여부 확인 ]
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			if( rs.next() ) { // 찜하기가 되어있는 경우 [ 검색 결과가 있으면 취소 ]
				sql = "delete from plike where pno = ? and mno = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps.executeUpdate();
				return 1;
			}else { // 찜하기가 안되어있는 경우 [ 검색 결과가 없으면 등록 ] 
				sql = "insert into plike( pno , mno ) values( ?, ? )";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps.executeUpdate();
				return 2;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 3;
	} // setplike e
	
	
	// 11. 장바구니에 선택한 제품의 옵션 저장 
	public boolean setcart( int pno, String psize, int amount, String pcolor, int mno ) {
		
		// 만약에 동일한 제품 옵션이 존재했을 때 수량만 증가하는 업데이트 처리 [ 중복검사 미구현 ]
		
		// 동일한 제품 옵션이 없을 때
		String sql =  "insert into cart( amount , pstno , mno )\r\n"
				+ "values (\r\n"
				+ "	"+ amount +", \r\n"
				+ "	(select pstno\r\n"
				+ "	from productstock pst, ( select psno from productsize where pno = "+ pno +" and psize = '"+ psize +"') sub\r\n"
				+ "	where pst.psno = sub.psno and pcolor = '"+ pcolor + "'), \r\n"
				+ "	"+ mno +"\r\n"
				+ " )";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("장바구니 제품저장 오류 : "+e);
		} return false;
	} // setcart e
	
	
	// 12. 회원번호의 모든 장바구니 호출
	public ArrayList< CartDto > getcart( int mno ) {
		ArrayList< CartDto > list = new ArrayList<>();
		
		String sql = "select\r\n"
				+ "	c.cartno, pst.psno, p.pname, p.pimg, \r\n"
				+ "    p.pprice, p.pdiscount, pst.pcolor, ps.psize, c.amount\r\n"
				+ "from \r\n"
				+ "	cart c natural join \r\n"
				+ "	productstock pst natural join\r\n"
				+ "    productsize ps natural join\r\n"
				+ "    product p\r\n"
				+ "where\r\n"
				+ "	c.mno = " + mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				CartDto cartdto = new CartDto(
						rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getFloat(6),
						rs.getString(7), rs.getString(8),
						rs.getInt(9));
				list.add(cartdto);
				System.out.println("list : " +list);
			} return list;
		} catch (Exception e) {
			System.out.println( "장바구니 호출 오류 : " +e);
		}
		return list;
	} // getcart e
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

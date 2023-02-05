import { useLoaderData } from "react-router-dom";

function Products() {
  const data = useLoaderData();
  return (
    <>
      <h1>Products</h1>
      <table>
        <tbody>
        <tr>
            <th>Product Name</th>
            <th>Product Description</th>
        </tr>
        {data.map((product) => (
          <tr key={product.id}>
            <td>{product.productName}</td>
            <td>{product.productDescription}</td>
          </tr>
        ))}
        </tbody>
      </table>
    </>
  );
}
export default Products;
export async function productsLoader() {
  const response = await fetch("http://localhost:8080/user/products");
  if (!response.ok) {
    console.log("Could not fetch Products");
  } else {
    const resData = await response.json();
    return resData;
  }
  return response;
}
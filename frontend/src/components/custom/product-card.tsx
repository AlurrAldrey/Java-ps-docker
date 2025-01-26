import * as React from "react"

import {
  Card,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Product } from "@/models/Product"


interface ProductCardProps {
    product: Product;
  }
  
  export function ProductCard({ product }: ProductCardProps) {
    return (
      <Card className="">
        <CardHeader>
          <CardTitle>{product.name}</CardTitle>
          <CardDescription>ID: {product.id}</CardDescription>
        </CardHeader>
      </Card>
    );
  }

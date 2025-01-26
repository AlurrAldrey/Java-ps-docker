"use client";

import { useState } from "react";
import { useRouter } from "next/navigation"; // Import useRouter for navigation
import { createProduct } from "@/services/productService";

import { Button } from "@/components/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";

export default function AddProduct() {
  const [name, setName] = useState("");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const router = useRouter(); // Initialize the router

  const handleSubmit = async (e?: any) => {
    e?.preventDefault(); // Prevent page reload
    setError("");
    setSuccess("");
    try {
      const product = { name }; // Assuming 'name' is the only field
      const response = await createProduct(product);
      setSuccess("Product created successfully!");
    } catch (err) {
      setError("Failed to create product.");
    }
  };

  const handleBack = () => {
    router.push("/products"); // Navigate to the products page
  };

  return (
    <div className="flex items-start justify-center min-h-screen pt-8">
      <div>

      <Button variant="secondary" onClick={handleBack}>
            Back to Products
      </Button>
      <Card className="w-[350px] mt-3">
        <CardHeader>
          <CardTitle>Create product</CardTitle>
          <CardDescription>Create a new product on the database</CardDescription>
        </CardHeader>
        <CardContent>
          <form onSubmit={handleSubmit}>
            <div className="grid w-full items-center gap-4">
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="name">Name</Label>
                <Input
                  id="name"
                  placeholder="Name of your product"
                  value={name} // Bind state
                  onChange={(e) => setName(e.target.value)} // Update state
                />
              </div>
            </div>
          </form>
        </CardContent>
        <CardFooter className="flex justify-between">
          <Button onClick={handleSubmit}>Create</Button>
          
          <div>
            {error && <p className="text-red-500 text-sm mt-2">{error}</p>}
            {success && <p className="text-sm mt-2">{success}</p>}
          </div>
        </CardFooter>
        </Card>
      </div>
    </div>
  );
}